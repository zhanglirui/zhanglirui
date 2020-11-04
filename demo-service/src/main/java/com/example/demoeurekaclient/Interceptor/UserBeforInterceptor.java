package com.example.demoeurekaclient.Interceptor;

import com.example.demoeurekaclient.common.CommandDTO;
import com.example.demoeurekaclient.common.Interceptor.ICommandInterceptor;
import com.example.demoeurekaclient.common.register.BeforeInterceptor;

/**
 * @author zhanglirui
 * @date 2020/11/4 4:38 下午
 */
@BeforeInterceptor
public class UserBeforInterceptor implements ICommandInterceptor {

    @Override
    public void before(CommandDTO command) {
        System.out.println("----------拦截器");
        System.out.println("----------拦截器");
        System.out.println("----------拦截器");
        System.out.println("----------拦截器");
        System.out.println("----------拦截器");
    }

}
