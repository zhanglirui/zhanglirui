package com.example.demoeurekaclient;

import javax.annotation.Resource;

import com.example.demoeurekaclient.spring.extend.TestBeanPostProcess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author zhanglirui
 * @date 2020/11/12 2:24 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoStartApplication.class)
public class TestBeanPostProcessTest {

    @Resource
    private TestBeanPostProcess testBeanPostProcess;

    @Test
    public void postProcessBeforeInitialization() {
        //testBeanPostProcess.
    }

    @Test
    public void postProcessAfterInitialization() {
    }
}