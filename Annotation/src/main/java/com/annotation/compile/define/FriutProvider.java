package com.annotation.compile.define;

import java.lang.annotation.*;

/**
 * 水果供应者注解
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface FriutProvider {
    /**
     * 供应商id
     * @return
     */
    int id() default -1;
    /**
     * 供应商名称
     * @return
     */
    String name() default "";
    /**
     * 供应商地址
     * @return
     */
    String address() default "";
}
