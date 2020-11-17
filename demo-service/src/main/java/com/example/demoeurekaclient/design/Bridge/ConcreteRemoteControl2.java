package com.example.demoeurekaclient.design.Bridge;

/**
 * @author zhanglirui
 * @date 2020/11/16 5:50 下午
 */
public class ConcreteRemoteControl2 extends RemoteControl {

    public ConcreteRemoteControl2(TV tv) {
        super(tv);
    }

    @Override
    public void on() {
        System.out.println("ConcreteRemoteControl2.on()");
        tv.on();
    }

    @Override
    public void off() {
        System.out.println("ConcreteRemoteControl2.off()");
        tv.off();
    }

    @Override
    public void tuneChannel() {
        System.out.println("ConcreteRemoteControl2.tuneChannel()");
        tv.tuneChannel();
    }
}
