package com.example.demoeurekaclient;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhanglirui
 * @date 2020/9/27 3:42 下午
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class RocketmqTest {


    private final static String nameServer = "localhost:9876";

    @Test
    public void testSend() throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        String nameServer = "localhost:9876";
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(nameServer);
        producer.start();
        for (int i = 0; i < 10; i++) {
            //指定消息发送的Topic是topic1。
            Message message = new Message("topic1", ("hello" + i).getBytes());
            //同步发送，发送成功后才会返回
            SendResult sendResult = producer.send(message);
            if (sendResult.getSendStatus() == SendStatus.SEND_OK) {
                System.out.println("消息发送成功：" + sendResult);
            } else {
                System.out.println("消息发送失败：" + sendResult);
            }
        }
        //使用完毕后需要把Producer关闭，以释放相应的资源
        producer.shutdown();
    }

    @Test
    public void testConsumer() throws Exception {

        String nameServer = "localhost:9876";

        //创建Consumer并指定消费者组。
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group1");
        //指定需要连接的Name Server
        consumer.setNamesrvAddr(nameServer);
        //订阅topic1上的所有Tag。
        consumer.subscribe("topic1", "*");
        //注册一个消息监听器
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println(Thread.currentThread().getName() + "收到了消息，数量是：" + msgs.size());
                AtomicInteger counter = new AtomicInteger();
                msgs.forEach(msg -> System.out.println(counter.incrementAndGet() + ".消息内容是：" + new String(msg.getBody())));
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者
        consumer.start();
        //为了确保Junit线程不立即死掉。
        TimeUnit.SECONDS.sleep(120);
    }

    /**
     * 同步发送消息
     * @throws Exception
     */
    @Test
    public void testSyncSend() throws Exception {

        String nameServer = "localhost:9876";

        //指定Producer的Group为group1
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        //指定需要连接的Name Server
        producer.setNamesrvAddr(nameServer);
        //发送消息前必须调用start()，其内部会进行一些初始化工作。
        producer.start();
        for (int i = 0; i < 10; i++) {
            //指定消息发送的Topic是topic1。
            Message message = new Message("topic1","tag0", ("hello" + i).getBytes());
            //同步发送，发送成功后才会返回
            SendResult sendResult = producer.send(message);
            if (sendResult.getSendStatus() == SendStatus.SEND_OK) {
                System.out.println("消息发送成功：" + sendResult);
            } else {
                System.out.println("消息发送失败：" + sendResult);
            }
        }
        //使用完毕后需要把Producer关闭，以释放相应的资源
        producer.shutdown();
    }

    /**
     * 异步发送消息
     * @throws Exception
     */
    @Test
    public void sendAsync() throws Exception {

        String nameServer = "localhost:9876";

        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(nameServer);
        producer.start();
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Message message = new Message("topic1", "tag1",
                ("send by async, no." + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println("发送成功：" + message);
                    latch.countDown();
                }

                @Override
                public void onException(Throwable throwable) {
                    System.out.println("发送失败");
                    latch.countDown();
                }
            });
        }
        latch.await();
        producer.shutdown();
    }

    /**
     * 消息的单向发送
     * @throws Exception
     */
    @Test
    public void sendOneway() throws Exception {

        String nameServer = "localhost:9876";

        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(nameServer);
        producer.start();
        for (int i=0; i<10; i++) {
            Message message = new Message("topic1", "tag2", ("单向发送的消息message send with oneway, no."+i).getBytes());
            producer.sendOneway(message);
        }
        producer.shutdown();
    }

    @Test
    public void sendWithTag() throws Exception {

        String nameServer = "localhost:9876";

        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(nameServer);
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("topic1", "tag0", ("hello with tag---" + i).getBytes());
            message.setTags("topic4");
            SendResult sendResult = producer.send(message);
            if (sendResult.getSendStatus() == SendStatus.SEND_OK) {
                System.out.println("消息发送成功：" + sendResult);
            } else {
                System.out.println("消息发送失败：" + sendResult);
            }
        }
        producer.shutdown();
    }

    @Test
    public void testConsumeByTag() throws Exception {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group2");
        consumer.setNamesrvAddr(nameServer);
        consumer.subscribe("topic1", "tag2||tag0||tag1||topic4");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println(Thread.currentThread().getName() + "收到了消息，数量是：" + msgs.size());
                AtomicInteger counter = new AtomicInteger();
                msgs.forEach(msg -> System.out.println(counter.incrementAndGet() + ".消息内容是：" + new String(msg.getBody())));
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        TimeUnit.SECONDS.sleep(120);
    }

    @Test
    public void testOrderSend() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr(this.nameServer);
        producer.start();
        for (int i=0; i<10; i++) {
            Message message = new Message("topic1", "tag5",
                (System.currentTimeMillis() + "---" + System.nanoTime() + "顺序消息测试hello ordered message " + i).getBytes());
            SendResult sendResult = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    int index = (int) arg;
                    //奇数放一个队列，偶数放一个队列
                    return mqs.get(index % mqs.size() % 2);
                }
            }, i);
            Assert.assertTrue(sendResult.getSendStatus() == SendStatus.SEND_OK);
        }
        producer.shutdown();
    }


    @Test
    public void testOrderConsume() throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group3");
        consumer.setNamesrvAddr(this.nameServer);
        consumer.subscribe("topic1", "tag5");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);//默认值，订阅以前的消息将被忽略
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
                System.out.println(Thread.currentThread().getName() + "消费消息：" + new String(msgs.get(0).getBody()));
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        TimeUnit.SECONDS.sleep(120);
        consumer.shutdown();
    }

}
