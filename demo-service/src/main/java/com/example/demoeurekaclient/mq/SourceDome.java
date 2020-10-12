package com.example.demoeurekaclient.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import static org.springframework.cloud.stream.messaging.Source.OUTPUT;

/**
 * 消息生产者spring cloud 的消息框架
 * @author zhanglirui
 * @date 2020/9/28 9:35 上午
 */
public interface SourceDome {
    // 这里的名称对应了spring.cloud.stream.rocketmq.bindings.<channelName>
    String OUTPUT = "outputTest";

    /**
     * 义了一个OUTPUT类型的Binding，名称为output，
     * 当不通过@Output指定Binding的名称时，默认会使用方法名作为Binding的名称
     * @return
     */
    @Output(SourceDome.OUTPUT)
    MessageChannel outputTest();

    /**
     * 生产者消息测试
     * @return
     */
    @Output("outPutZlr")
    MessageChannel outPutZlr();
}
