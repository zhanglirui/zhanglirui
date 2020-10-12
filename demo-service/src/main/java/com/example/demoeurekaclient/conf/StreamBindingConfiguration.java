package com.example.demoeurekaclient.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.config.BindingProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanglirui
 * @date 2020/9/28 2:09 下午
 */
@Configuration
public class StreamBindingConfiguration{

    @Value("${spring.cloud.stream.bindings.outputTest.destination}")
    private String destination;

    @Value("${spring.cloud.stream.bindings.inputTest.destination}")
    private String destination1;

    @Value("${spring.cloud.stream.bindings.inputTest.group}")
    private String group;

    @Bean
    public BindingProperties bindingProperties(){
        BindingProperties bindingProperties = new BindingProperties();
        bindingProperties.setDestination(destination);
        return bindingProperties;
    }

    @Bean
    public BindingProperties bindingProperties1(){
        BindingProperties bindingProperties = new BindingProperties();
        bindingProperties.setDestination(destination1);
        bindingProperties.setGroup(group);
        return bindingProperties;
    }
}
