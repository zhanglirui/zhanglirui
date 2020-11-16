package com.example.demoeurekaclient.design.Observer;

/**
 * @author zhanglirui
 * @date 2020/11/16 3:28 下午
 */
public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}
