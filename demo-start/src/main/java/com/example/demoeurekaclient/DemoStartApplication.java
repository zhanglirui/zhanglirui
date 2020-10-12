package com.example.demoeurekaclient;

import com.example.demoeurekaclient.mq.CustomBinding;
import com.example.demoeurekaclient.mq.SinkDome;
import com.example.demoeurekaclient.mq.SourceDome;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication(scanBasePackages = "com.example.demoeurekaclient")
@EnableEurekaClient
@EnableCircuitBreaker       // 启用Hystrix
//@EnableHystrixDashboard   // 启用Hystrix的控制面板
//@RibbonClient(value = "hello",configuration = RibbonConfiguration.class)  //声明一个Ribbon Client，指定Client的名称,配置是覆盖默认配置使用的
//@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@RibbonClient(value = "hello")
//@EnableZuulProxy()  // @EnableZuulProxy以启用Spring Cloud内置的Zuul反向代理
@EnableFeignClients // 启用Feign客户端支持
//@EnableBinding({Processor.class , SourceDome.class, SinkDome.class, CustomBinding.class})
@EnableBinding({Source.class , SourceDome.class})
// 在一个接口中可以同时定义多个Binding，只需要定义多个@Input或@Output标注的方法。
// Processor接口同时继承了Source和Sink接口，所以当@EnableBinding指定了Processor接口时相当于同时应用了两个Binding
public class DemoStartApplication {

     public static void main(String[] args) {
        SpringApplication.run(DemoStartApplication.class, args);
    }

}
