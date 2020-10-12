package com.example.demoeurekaclient;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhanglirui
 * @date 2020/9/22 11:37 上午
 */
@RestController
@RequestMapping(value = "hello")
@DefaultProperties(defaultFallback = "fallback",commandProperties = {
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "10000"),
    @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "5")
})
public class HelloEurekaController {

    @Resource
    private EurekaClientConfigBean eurekaClientConfigBean;

    @Resource
    private EurekaClient eurekaClient;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplateBuilder restTemplateBuilder;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "client",method = RequestMethod.GET)
    public String helloClient() throws URISyntaxException {
        String virtualHostname = "zlr-dome-client-test";
        InstanceInfo serverFromEureka = eurekaClient.getNextServerFromEureka(virtualHostname, false);

        String homePageUrl = serverFromEureka.getHomePageUrl();
        String ss = homePageUrl + "domeClient/test";
        String result = this.restTemplateBuilder.build().getForObject(new URI(ss), String.class);
        //return result;
        return "eureka客户端调用服务------"+serverFromEureka.getHomePageUrl()+result;
    }

    @RequestMapping(value = "client1",method = RequestMethod.GET)
    public String helloClient1() throws URISyntaxException {
        String virtualHostname = "zlr-dome-client-test";
        List<ServiceInstance> instances = this.discoveryClient.getInstances(virtualHostname);
        if (CollectionUtils.isEmpty(instances)) {
            return "带哦用失败";
        }
        String instanceUrl = instances.get(0).getUri().toString();
        String serviceUrl = instanceUrl + "domeClient/test";
        String result = this.restTemplateBuilder.build().getForObject(new URI(serviceUrl), String.class);
        return result;
    }

    @RequestMapping(value = "client2",method = RequestMethod.GET)
    public String helloClient2() {

        return "服务调用成功";
    }

    int count;

    @HystrixCommand(fallbackMethod = "fallback",commandKey="springcloud",threadPoolKey = "springcloud",
        commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "3000"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "3000"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false"),

            @HystrixProperty(name = "execution.isolation.strategy",value = "SEMAPHORE"),
            @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests",value = "10"),

            @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests",value = "10"),
        },
        threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "15"),
            @HystrixProperty(name = "maxQueueSize", value = "10"),
            @HystrixProperty(name = "queueSizeRejectionThreshold",value = "11"),
            @HystrixProperty(name = "maximumSize",value = "10"),
            @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize",value = "true"),
            @HystrixProperty(name = "keepAliveTimeMinutes",value = "1"),
        })
    @GetMapping("error")
    public String error() {
        String result = ++count + " Error. " + LocalDateTime.now();
        System.out.println(result);
        if (count % 2 != 0) {
            throw new IllegalStateException("调用异常了");
        }
        return "调用正常了";
    }

    public String fallback() {
        return "result from fallback. 回滚方法被调用";
    }


    @HystrixCommand(fallbackMethod="fallbackWithParam",defaultFallback = "fallback",commandProperties = {
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "30000"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" ,value = "5000"),
        @HystrixProperty(name = "execution.timeout.enabled", value = "false")
    })
    @GetMapping("error/{param}")
    public String error(@PathVariable("param") String param) {
        throw new IllegalStateException();
    }

    public String fallbackWithParam(String param) {
        return "fallbackMethod 的回滚方法被调用，fallback with param : " + param;
    }


    @RequestMapping(value = "ribbon", method = RequestMethod.GET)
    public String ribbonTest(){
       return restTemplate.getForObject("http://spring2/domeClient/test",String.class)+"啦啦啦";
    }


    @GetMapping("retry/{sub}")
    public String retryAny(@PathVariable("sub") String sub) {
        System.out.println("sub =--------------- " + sub);
        System.out.println("sub =--------------- " + sub);
        System.out.println("sub =--------------- " + sub);
        System.out.println("sub =--------------- " + sub);
        System.out.println("sub =--------------- " + sub);
        System.out.println("sub =--------------- " + sub);
        System.out.println("sub =--------------- " + sub);

        String result = this.restTemplate.getForObject("http://spring2/{sub}", String.class, sub);
        return result;
    }

}
