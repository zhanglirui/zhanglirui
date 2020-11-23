package com.example.demoeurekaclient.redis.messagr;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhanglirui
 * @date 2020/11/20 4:24 下午
 */
@Configuration
public class JedisConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private String port;

    /**  链接超时时间*/
    private static final int DEFAULT_TIMEOUT = 200000;
    /**  调用失败重试次数*/
    private static final int DEFAULT_REDIRECTIONS = 5;
    /**  pool最大连接数*/
    private static final int MAX_TOTAL = 200;
    /**  最大空闲连接数*/
    private static final int MAX_IDLE = 50;

    /**客户端链接配置*/
    private static final JedisPoolConfig DEFAULT_CONFIG = new JedisPoolConfig();

    @Bean
    public JedisCluster createJedis(){
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort(redisHost, 7000));
        DEFAULT_CONFIG.setMaxTotal(MAX_TOTAL);
        DEFAULT_CONFIG.setMaxIdle(MAX_IDLE);
        DEFAULT_CONFIG.setTestOnBorrow(false);
        DEFAULT_CONFIG.setTestOnReturn(false);
        DEFAULT_CONFIG.setTimeBetweenEvictionRunsMillis(60000);

        JedisCluster jc = new JedisCluster(jedisClusterNode, DEFAULT_TIMEOUT, DEFAULT_TIMEOUT,DEFAULT_REDIRECTIONS,DEFAULT_CONFIG);
        return jc;
    }
}
