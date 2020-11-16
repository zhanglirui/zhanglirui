package com.example.demoeurekaclient.design.Mediator;

/**
 * @author zhanglirui
 * @date 2020/11/16 3:04 下午
 */
public class Alarm extends Colleague {

    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("alarm");
    }

    public void doAlarm() {
        System.out.println("doAlarm()");
    }
}
