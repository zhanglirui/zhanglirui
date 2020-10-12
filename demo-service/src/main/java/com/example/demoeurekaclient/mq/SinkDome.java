package com.example.demoeurekaclient.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

import static org.springframework.cloud.stream.messaging.Sink.INPUT;

/**
 * 消息消费类型
 * @author zhanglirui
 * @date 2020/9/28 9:39 上午
 */
public interface SinkDome {

    /**
     * 它定义了一个INPUT类型的Binding，名称为input，
     * 当不通过@Input指定Binding的名称时，默认会使用方法名作为Binding的名称
     * @return
     */
    @Input
    SubscribableChannel inputTest();

    /**
     * 消息消费者测试
     * @return
     */
    //SubscribableChannel inputZlr();
}
