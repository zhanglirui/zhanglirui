package com.example.demoeurekaclient.common.register;

import com.example.demoeurekaclient.common.register.BeforeInterceptor;
import com.example.demoeurekaclient.common.register.BeforeInterceptorRegister;
import com.example.demoeurekaclient.common.register.Iregister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注册工厂
 * @author zhanglirui
 * @date 2020/11/4 11:56 上午
 */
@Component
public class RegisterFactory {

    @Autowired
    private BeforeInterceptorRegister beforeInterceptorRegister;

    public void setBeforeInterceptorRegister(
        BeforeInterceptorRegister beforeInterceptorRegister) {
        this.beforeInterceptorRegister = beforeInterceptorRegister;
    }


    public Iregister getRegister(Class<?> targetClz){
        BeforeInterceptor annotation = targetClz.getDeclaredAnnotation(BeforeInterceptor.class);

        if(annotation != null){
            return beforeInterceptorRegister;
        }
        return null;
    }

}
