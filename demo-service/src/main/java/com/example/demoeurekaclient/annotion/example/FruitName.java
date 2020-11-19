package com.example.demoeurekaclient.annotion.example;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 水果名称注解
 *
 * @author zhanglirui
 * @date 2020/11/17 4:00 下午
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitName {

    String value() default "";
}
