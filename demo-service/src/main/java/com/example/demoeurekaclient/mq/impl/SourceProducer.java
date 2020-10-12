package com.example.demoeurekaclient.mq.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.example.demoeurekaclient.mq.SourceDome;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/9/28 9:59 上午
 */
@Component
public class SourceProducer {

    @Resource
    private SourceDome sourceDome;

    public void sendMessages(String msg) {
        String payload = msg;
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "testTag");
        MessageHeaders messageHeaders = new MessageHeaders(headers);
        Message<String> message = MessageBuilder.createMessage(payload, messageHeaders);
        boolean send = sourceDome.outputTest().send(message);

        int r = 1;
    }

   /* @Autowired
    @Qualifier(value = "outPutZlr")
    private MessageChannel messageChannel;

    public void sendMessagesTest(String msg) {
        String payload = msg;
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "testTag");
        MessageHeaders messageHeaders = new MessageHeaders(headers);
        Message<String> message = MessageBuilder.createMessage(payload, messageHeaders);
        this.messageChannel.send(message);
    }*/

}
