package com.example.demoeurekaclient.design.Observer;

/**
 * @author zhanglirui
 * @date 2020/11/16 3:29 下午
 */
public interface Observer {

    void update(float temp, float humidity, float pressure);
}
