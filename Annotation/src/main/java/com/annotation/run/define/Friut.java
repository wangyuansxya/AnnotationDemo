package com.annotation.run.define;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果注解
 * 运行时注解声明
 */
@Documented//——生成说明文档，添加类的解释
@Inherited//——允许子类继承父类中的注解。
@Retention(RetentionPolicy.RUNTIME)//— —注解运行状态
@Target(ElementType.FIELD)// — —注解用于什么地方
public @interface Friut {

    enum Color { BLUE, RED, GREEN};

    /**
     * 水果颜色
     * @return
     */
    Color fruitColor() default Color.RED;

}
