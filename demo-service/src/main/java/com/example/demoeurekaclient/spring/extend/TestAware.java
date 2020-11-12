package com.example.demoeurekaclient.spring.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/11/12 3:43 下午
 */
@Component
public class TestAware implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public  BeanFactory beanFactory;
    public  ApplicationContext applicationContext;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("获取BeanFactory----------"+beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("获取BeanName---------"+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("获取applicationContext  --------"+applicationContext);
    }
}
