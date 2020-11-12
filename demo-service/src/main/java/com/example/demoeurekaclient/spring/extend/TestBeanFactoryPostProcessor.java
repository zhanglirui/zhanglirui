package com.example.demoeurekaclient.spring.extend;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/11/12 3:58 下午
 */
@Component
public class TestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("myObj");
        
        String scope = beanDefinition.getScope();
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        System.out.println("bean的属性值-----"+propertyValues);
        System.out.println("bean的属性值-----"+beanDefinition.getBeanClassName());
        System.out.println("修改前的bean的作用范围------"+scope);
        beanDefinition.setScope("prototype");
        System.out.println("bean的修改后的属性值-----"+propertyValues);
    }
}
