package com.annotation.run;


import com.annotation.compile.define.Friut;
import com.annotation.compile.define.FriutName;
import com.annotation.compile.define.FriutProvider;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {
        //获取clazz所有的成员变量
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {

            if(field.isAnnotationPresent(FriutName.class)) {
                FriutName friutName = field.getAnnotation(FriutName.class);
                System.out.println("friutName = [" + friutName.value() + "]");
            }

            if(field.isAnnotationPresent(Friut.class)) {
                Friut friut = field.getAnnotation(Friut.class);
                System.out.println("friutcolor = [" + friut.fruitColor() + "]");
            }

            if(field.isAnnotationPresent(FriutProvider.class)) {
                FriutProvider provider = field.getAnnotation(FriutProvider.class);
                System.out.println("供应商编号 = [" + provider.id() + "]");
                System.out.println("供应商名称 = [" + provider.name() + "]");
                System.out.println("供应商地址 = [" + provider.address() + "]");
            }
        }

    }

}
