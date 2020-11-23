package com.example.demoeurekaclient;

import java.util.HashSet;
import java.util.Set;

import com.example.demoeurekaclient.redis.RedisDao;
import com.example.demoeurekaclient.redis.messagr.Receiver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.Protocol;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

/**
 * @author zhanglirui
 * @date 2020/11/19 10:15 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoStartApplication.class)
@Slf4j
public class RedisDaoTest implements ApplicationContextAware {

    @Autowired
    RedisDao redisDao;

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void setKey() {
        redisDao.setKey("name", "forezp");
        redisDao.setKey("age", "11");
        log.info(redisDao.getValue("name"));
        log.info(redisDao.getValue("age"));
    }

    @Test
    public void sendMessager() {
        StringRedisTemplate template = applicationContext.getBean(StringRedisTemplate.class);
        Receiver receiver = applicationContext.getBean(Receiver.class);
        while (receiver.getCount() == 0) {

            LOGGER.info("Sending message...,发送次数：" + receiver.getCount());

            template.convertAndSend("chat", "Hello from Redis!");
        }
    }

    @Test
    public void jedisSentinel() {
        Set<String> sentinelSet = new HashSet<>();
        sentinelSet.add("127.0.0.1:26739");
        sentinelSet.add("127.0.0.1:26380");
        sentinelSet.add("127.0.0.1:26381");

        String masterName = "mymaster";

        JedisSentinelPool sentinelPool = new JedisSentinelPool(masterName, sentinelSet, new GenericObjectPoolConfig(),
            10000, 10000, null, Protocol.DEFAULT_DATABASE);
        System.out.println(sentinelPool.getResource().get("ceshi1"));
    }

    @Autowired
    JedisCluster createJedis;

    @Test
    public void jedisCluster() {
        // todo 多练习练习集群的数据格式命令
        String set = createJedis.set("ceshi1", "ceshi1");

        String ceshi1 = createJedis.get("ceshi1");
        System.out.println("ceshi1的值为"+ceshi1);
    }



}