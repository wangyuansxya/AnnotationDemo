package com.annotation.compile.define;


import java.lang.annotation.*;

/**
 * 水果名称注解
 */
@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface FriutName {
    String value();
}
