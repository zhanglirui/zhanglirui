package com.example.demoeurekaclient.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.demoeurekaclient.enums.StatusTypeEnum;

/**
 * @author zhanglirui
 * @date 2020/11/3 9:53 上午
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    StatusTypeEnum type() default StatusTypeEnum.EXIST;
}
