package com.example.demoeurekaclient.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * @author zhanglirui
 * @date 2020/11/11 5:59 下午
 */
public class TestAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(
            "after " + target.getClass().getSimpleName() + "." + method.getName() + "()");
    }
}
