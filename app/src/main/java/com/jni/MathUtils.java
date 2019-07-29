package com.jni;

/*
 NDK开发流程：

 在java里面写native代码

 在main目录下创建jni目录写C代码，--生成头文件

 配置动态链接库的名称

 加载动态链接库

 使用
*/
public class MathUtils {

    static {
        System.loadLibrary("native-lib");
    }

    public native String stringFromJNI(String str);

    public native int add(int i, int y);

//    public native int add(int i, int y);
//
//    public native int add(int i, int y);
//
//    public native int add(int i, int y);



}
