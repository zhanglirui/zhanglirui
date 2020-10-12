package com.example.demoeurekaclient.impl;

import com.example.demoeurekaclient.RestFeignService;
import com.example.demoeurekaclient.entry.MyObj;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/9/24 2:32 下午
 */
@Component
public class RestFeignServiceImpl implements RestFeignService {
    @Override
    public String getRemoteService() {
        return "Rest Feign 断路器启动了";
    }

    @Override
    public MyObj customHttpMessageConverter(MyObj obj) {
        MyObj myObj = new MyObj();
        myObj.setText("Rest Feign 断路器启动了");
        return myObj;
    }
}
