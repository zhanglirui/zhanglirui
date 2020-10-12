package com.example.demoeurekaclient.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author zhanglirui
 * @date 2020/9/27 5:32 下午
 */
public interface CustomBinding {

    String INPUT1 = "input1";
    String OUTPUT1 = "output1";

    @Input
    SubscribableChannel input1();

    @Output
    MessageChannel output1();
}
