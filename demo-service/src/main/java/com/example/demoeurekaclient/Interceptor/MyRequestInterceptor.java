package com.example.demoeurekaclient.Interceptor;

import java.util.UUID;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/9/24 2:25 下午
 */
@Component
public class MyRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("request-id", UUID.randomUUID().toString());
    }
}
