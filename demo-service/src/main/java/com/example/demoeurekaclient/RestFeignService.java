package com.example.demoeurekaclient;

import com.example.demoeurekaclient.conf.RestFeignConfiguration;
import com.example.demoeurekaclient.entry.MyObj;
import com.example.demoeurekaclient.impl.HelloServiceFallbackFactory;
import com.example.demoeurekaclient.impl.RestFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zhanglirui
 * @date 2020/9/23 8:25 下午
 */
// @FeignClient("spring2")
// @FeignClient(name = "spring2", url = "http://localhost:8901")
//@FeignClient(name = "spring2", url = "localhost:8901",configuration = RestFeignConfiguration.class)
@FeignClient(name = "spring2", url = "localhost:8901"
    , fallbackFactory = HelloServiceFallbackFactory.class
    , fallback = RestFeignServiceImpl.class
    /*, primary = false*/)
public interface RestFeignService {

    /**
     * 获取远程服务
     * @return
     */
    @GetMapping("domeClient/zuul")
    String getRemoteService();

    @GetMapping("domeClient/zuul")
    MyObj customHttpMessageConverter(@RequestBody MyObj obj);

}
