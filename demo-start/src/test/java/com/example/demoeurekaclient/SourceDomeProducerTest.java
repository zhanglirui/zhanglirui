package com.example.demoeurekaclient;

import javax.annotation.Resource;

import com.example.demoeurekaclient.mq.impl.SinkConsumer;
import com.example.demoeurekaclient.mq.impl.SourceProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhanglirui
 * @date 2020/9/28 10:13 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SourceDomeProducerTest {

    @Autowired
    private SourceProducer sourceProducer;

    @Resource
    private SinkConsumer sinkConsumer;

    @Test
    public void testDome(){
        String msg = "我是 spring cloud stream 的测试消息";
        for (int i=0; i<10; i++) {
            sourceProducer.sendMessages(msg+"-----"+i);
        }

    }

   /* @Test
    public void testDome11(){
        String msg = "我是 spring cloud stream 的测试消息";
        for (int i=0; i<10; i++) {
            sourceProducer.sendMessagesTest(msg+"-----"+i);
        }

    }*/

    @Test
    public void testCustomBinding(){
        sinkConsumer.inputConsumer(null);
    }

}
