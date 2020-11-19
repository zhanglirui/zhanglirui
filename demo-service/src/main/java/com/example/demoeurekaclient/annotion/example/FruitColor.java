package com.example.demoeurekaclient.annotion.example;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 水果颜色注解
 *
 * @author zhanglirui
 * @date 2020/11/17 4:01 下午
 */
@Target(FIELD)
@Retention(RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 颜色枚举
     */
    public enum Color{ BLUE,RED,GREEN};

    /**
     * 水果颜色
     * @return
     */
    Color fruitColor() default Color.GREEN;





}
