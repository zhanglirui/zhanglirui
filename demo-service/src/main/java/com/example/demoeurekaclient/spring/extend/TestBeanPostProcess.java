package com.example.demoeurekaclient.spring.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 在bean初始化前后做事情
 * @author zhanglirui
 * @date 2020/11/12 2:20 下午
 */
//@Component
public class TestBeanPostProcess implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before 初始化前执行"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after 初始化后执行"+beanName);
        return null;
    }
}
