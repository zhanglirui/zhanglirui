package com.example.demoeurekaclient.spring.extend;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/11/12 2:48 下午
 */
//@Component
public class TestInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("before  实列化前置执行------"+beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("after  实列化后置执行------"+beanName);
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
        String beanName) throws BeansException {
        System.out.println("Bean的pvs  ------"+pvs);
        System.out.println("处理Bean属性之前  ------"+ Arrays.toString(pds));
        System.out.println("Bean的对象 ------"+bean);
        System.out.println("Bean的名称  ------"+beanName);
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("before  初始化前置执行------"+beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after  初始化后置执行------"+beanName);
        return null;
    }
}
