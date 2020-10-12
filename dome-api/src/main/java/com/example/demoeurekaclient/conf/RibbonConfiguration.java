package com.example.demoeurekaclient.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhanglirui
 * @date 2020/9/23 11:52 上午
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule iRule(){
        return new RoundRobinRule();
    }

    @Bean
    @LoadBalanced
    @Primary
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Bean
    public RestTemplate commonRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

   /* @Bean
    @LoadBalanced
    @Primary
    public WebClient.Builde webClientBuilder(){
        return WebClient.builder();
    }*/


}
