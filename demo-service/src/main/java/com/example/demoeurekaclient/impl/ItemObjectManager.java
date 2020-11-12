package com.example.demoeurekaclient.impl;

import java.beans.PropertyDescriptor;

import com.example.demoeurekaclient.entry.ItemObject;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * InstantiationAwareBeanPostProcessor // 构造器前后
 * BeanPostProcessor // setter属性前后
 * BeanFactoryPostProcessor // bean定义前后执行
 * BeanFactoryAware // 获取BeanFactory对象及BeanFactory中的对象
 * FactoryBean // 以通过实现getObject方法，实现加载我们想要的Bean
 *
 * @author zhanglirui
 * @date 2020/11/9 8:29 下午
 */
public class ItemObjectManager implements BeanFactoryAware, FactoryBean,
    BeanPostProcessor , BeanFactoryPostProcessor, InstantiationAwareBeanPostProcessor {

    // BeanFactoryAware
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        ItemObject bean = beanFactory.getBean(ItemObject.class);
    }


    // FactoryBean
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }


    // BeanPostProcessor
    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    // BeanFactoryPostProcessor
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    @Override
    @Nullable
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    @Nullable
    public PropertyValues postProcessPropertyValues(
        PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {

        return pvs;
    }
}
