package com.example.demoeurekaclient.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanglirui
 * @date 2020/9/22 11:44 上午
 */
@Configuration
public class ConfigEurekaClient {

    //@Value("${server.port}")
    private String erverPort;

    //@Bean(name = "eurekaClientConfigBean")
    public EurekaClientConfigBean eurekaClientConfigBean(){
        EurekaClientConfigBean eurekaClientConfigBean = new EurekaClientConfigBean();
        eurekaClientConfigBean.setEurekaServerPort(erverPort);
        return eurekaClientConfigBean;
    }
}
