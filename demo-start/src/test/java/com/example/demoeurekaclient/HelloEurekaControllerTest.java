package com.example.demoeurekaclient;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author zhanglirui
 * @date 2020/9/23 11:34 上午
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HelloEurekaControllerTest {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void test (){
        String serviceId = "spring2";
        for (int i=0; i<5; i++) {
            ServiceInstance instance = this.loadBalancerClient.choose(serviceId);
            System.out.println(i + ". " + instance.getUri());
        }
    }

}