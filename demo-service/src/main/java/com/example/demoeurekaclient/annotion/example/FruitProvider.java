package com.example.demoeurekaclient.annotion.example;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author zhanglirui
 * @date 2020/11/17 4:06 下午
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitProvider {

    /**
     * 供应商编号
     * @return
     */
    public int id() default -1;

    /**
     * 供应商名称
     * @return
     */
    public String name() default "";

    /**
     * 供应商地址
     * @return
     */
    public String address() default "";
}
