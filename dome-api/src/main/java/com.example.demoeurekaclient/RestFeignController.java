package com.example.demoeurekaclient;

import javax.annotation.Resource;

import com.example.demoeurekaclient.entry.MyObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglirui
 * @date 2020/9/23 8:11 下午
 */
@RestController
@RequestMapping("feign")
public class RestFeignController {

    final Logger logger =  LoggerFactory.getLogger(RestFeignController.class);

    @Resource
    private RestFeignService restFeignService;

    @RequestMapping(value = "demoTest",method = RequestMethod.GET)
    public String demoTest(){

        logger.info("开始调用服务");

        String service = restFeignService.getRemoteService();

        logger.info("调用服务cg");
        return service;
    }


    @GetMapping("converter/{text}")
    public String converter(@PathVariable("text") String text){

        logger.info("开始调用服务");
        MyObj myObj1 = new MyObj();
        myObj1.setText(text);
        MyObj myObj = restFeignService.customHttpMessageConverter(myObj1);

        logger.info("调用服务cg");
        return myObj.toString();
    }

}
