package com.annotation.run.define;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 水果供应者注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
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
