package com.example.demoeurekaclient.conf;

import java.util.Arrays;

import com.example.demoeurekaclient.common.CQRSBootstrap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhanglirui
 * @date 2020/11/4 11:26 上午
 */
//@Configuration
public class CQRSconfig {

    @Bean(initMethod = "init")
    public CQRSBootstrap cqrsBootstrap(){
        CQRSBootstrap cqrsBootstrap = new CQRSBootstrap();
        cqrsBootstrap.setPackages(Arrays.asList("com.example.demoeurekaclient"));
        return cqrsBootstrap;
    }
}
