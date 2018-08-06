package com.annotation.compile.define;


import java.lang.annotation.*;

/**
 * 水果注解
 * 编译时注解声明
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface Friut {

    enum Color { BLUE, RED, GREEN};

    /**
     * 水果颜色
     * @return
     */
    Color fruitColor() default Color.RED;

}
