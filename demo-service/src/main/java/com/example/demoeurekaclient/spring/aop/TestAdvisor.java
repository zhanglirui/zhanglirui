package com.example.demoeurekaclient.spring.aop;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

/**
 * @author zhanglirui
 * @date 2020/11/11 6:00 下午
 */
public class TestAdvisor implements PointcutAdvisor {

    /**
     * 获取切入点
     * @return
     */
    @Override
    public Pointcut getPointcut() {
        return new TestPointcut();
    }

    /**
     * 获取通知
     * @return
     */
    @Override
    public Advice getAdvice() {
        return new TestAfterAdvice();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
