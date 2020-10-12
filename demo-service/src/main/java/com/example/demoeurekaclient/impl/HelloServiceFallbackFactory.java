package com.example.demoeurekaclient.impl;

import com.example.demoeurekaclient.RestFeignService;
import com.example.demoeurekaclient.entry.MyObj;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/9/24 2:41 下午
 */
@Component
public class HelloServiceFallbackFactory implements FallbackFactory<RestFeignService> {
    @Override
    public RestFeignService create(Throwable throwable) {
        return new RestFeignService() {
            @Override
            public String getRemoteService() {
                return "fallback for helloWorld，reason is：" + throwable.getMessage();
            }

            @Override
            public MyObj customHttpMessageConverter(MyObj obj) {
                return null;
            }
        };
    }
}
