package com.example.demoeurekaclient.design.Facade;

/**
 * @author zhanglirui
 * @date 2020/11/17 11:35 上午
 */
public class SubSystem {

    public void turnOnTV() {
        System.out.println("turnOnTV()");
    }

    public void setCD(String cd) {
        System.out.println("setCD( " + cd + " )");
    }

    public void startWatching(){
        System.out.println("startWatching()");
    }
}
