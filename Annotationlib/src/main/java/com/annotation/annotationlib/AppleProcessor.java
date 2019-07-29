package com.annotation.annotationlib;

import com.annotation.compile.define.Friut;
import com.annotation.compile.define.FriutName;
import com.annotation.compile.define.FriutProvider;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

public class AppleProcessor extends AbstractProcessor {

    Messager messager;
    Filer filer;//Filer是个接口，支持通过注解处理器创建新文件

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        messager = processingEnvironment.getMessager();
        filer = processingEnvironment.getFiler();
    }

    /**
     * 注解支持的Java版本
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    /**
     * 支持的注解类型
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> set = new HashSet<>();
        set.add(Friut.class.getName());
        set.add(FriutName.class.getName());
        set.add(FriutProvider.class.getName());
        return set;
    }

    private static final String EXT = "_BindData";


    /**
     *
     * @param annotations 请求处理的注解类型
     * @param roundEnv 有关当前和以前的信息环境
     * @return 如果返回 true，则这些注解已声明并且不要求后续 Processor 处理它们；
     *         如果返回 false，则这些注解未声明并且可能要求后续 Processor 处理它们

     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        String genaratePackageName = "";
        Name originClassName;
        String genarateClassName = "";

        //List<MethodSpec> list = new ArrayList<>();

        List<MethodSpec> methods = new ArrayList<>();
        //Map<String, MethodSpec> map = new HashMap<>();


        for (TypeElement t : annotations) {
            for (Element e : roundEnv.getElementsAnnotatedWith(t)) {
                messager.printMessage(Diagnostic.Kind.NOTE, "Printing: " + e.toString());

                //1.获取注解
//                Friut f = e.getAnnotation(Friut.class);
//                if(f != null) {
//                    System.out.println("Friut = [" + f.fruitColor() + "]");
//                }
//
//                FriutName fn = e.getAnnotation(FriutName.class);
//                if (fn != null) {
//                    System.out.println("FriutName = [" + fn.value() + "]");
//                }
//
//                FriutProvider fp = e.getAnnotation(FriutProvider.class);
//                if(fp != null) {
//                    System.out.println("供应商编号 = [" + fp.id() + "]");
//                    System.out.println("供应商名称 = [" + fp.name() + "]");
//                    System.out.println("供应商地址 = [" + fp.address() + "]");
//                }

                Element enclosingElement = e.getEnclosingElement();
                // 获取父元素的全类名, 用来生成包名
                String enclosingQualifiedName;
                if(enclosingElement instanceof PackageElement){
                    enclosingQualifiedName = ((PackageElement)enclosingElement).getQualifiedName().toString();
                }else {
                    enclosingQualifiedName = ((TypeElement)enclosingElement).getQualifiedName().toString();
                }

                // 生成的包名
                genaratePackageName = enclosingQualifiedName.substring(0, enclosingQualifiedName.lastIndexOf('.'));
                originClassName = enclosingElement.getSimpleName();
                // 生成的类名
                genarateClassName = enclosingElement.getSimpleName() + EXT;
                // 创建Java文件
                CodeBlock.Builder builder = CodeBlock.builder();
                Friut[] f = e.getAnnotationsByType(Friut.class);
                String methodName = "apple";
                for (int i = 0; i < f.length; i++) {
                    builder.add("$T.out.println($S)", System.class, "Friut: " + f[i].fruitColor());
                    methodName = Friut.class.getSimpleName();
                }
                FriutName fn = e.getAnnotation(FriutName.class);
                if(fn != null) {
                    builder.add("$T.out.println($S)", System.class, "FriutName: " + fn.value());
                    methodName = FriutName.class.getSimpleName();
                }
                FriutProvider fp = e.getAnnotation(FriutProvider.class);
                if(fp != null) {
                    builder.add("$T.out.println($S);", System.class, "供应商编号: " + fp.address());
                    builder.add("$T.out.println($S);", System.class, "供应商名称: " + fp.id());
                    builder.add("$T.out.println($S)", System.class, "供应商地址: " + fp.name());
                    methodName = FriutProvider.class.getSimpleName();
                }
                methods.add(buildMethod(genarateClassName + methodName, builder.build()));

            }
        }

        /*methods.add(MethodSpec.constructorBuilder()
                .addParameter(ParameterSpec.builder(originClassName.getClass(), "target").build())
                .addModifiers(Modifier.PUBLIC)
                .build());*/

        if(genarateClassName != null && genarateClassName.length() > 0) {
            write(genaratePackageName, genarateClassName, methods);
        }

        return false;
    }

    private MethodSpec buildMethod(String methodName, CodeBlock code) {
        MethodSpec method = MethodSpec.methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .returns(TypeName.VOID)
                .addParameter(String.class, "test")
                //.addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .addStatement(code)
                .build();
        return method;
    }




    public void write(String genaratePackageName, String genarateClassName, Iterable<MethodSpec> methods) {
        /*MethodSpec method = MethodSpec.methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .returns(TypeName.VOID)
                .addParameter(String.class, "test")
                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                .addStatement(builder.build())
                .build();*/
        TypeSpec className = TypeSpec.classBuilder(genarateClassName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethods(methods)
                .build();
        JavaFile javaFile = JavaFile.builder(genaratePackageName, className)
                .build();
        try {
            javaFile.writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
