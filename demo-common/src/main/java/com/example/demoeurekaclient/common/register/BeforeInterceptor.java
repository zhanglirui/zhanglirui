package com.example.demoeurekaclient.common.register;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.example.demoeurekaclient.common.CommandDTO;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/11/4 3:50 下午
 */
@Inherited
@Component
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BeforeInterceptor {

    Class<? extends CommandDTO>[] commands() default {};
}
