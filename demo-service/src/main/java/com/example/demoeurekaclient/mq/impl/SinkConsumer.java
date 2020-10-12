package com.example.demoeurekaclient.mq.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/9/28 11:41 上午
 */
@Component
@Slf4j
public class SinkConsumer {

    @StreamListener(target = "outPutZlr")
    public void inputConsumer(String message) {
        LoggerFactory.getLogger(SinkConsumer.class).info("从Binding-{}收到信息-{}", Sink.INPUT, message);
    }

}
