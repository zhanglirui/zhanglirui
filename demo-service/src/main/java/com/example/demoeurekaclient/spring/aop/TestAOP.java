package com.example.demoeurekaclient.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author zhanglirui
 * @date 2020/11/11 6:04 下午
 */
public class TestAOP {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("demo-start/src/main/resources/spring"
            + "/spring-manager.xml");
        TestTarget target = (TestTarget) applicationContext.getBean("testAOP");
        target.test();
        System.out.println("----------------");
        target.test2();
    }

}
