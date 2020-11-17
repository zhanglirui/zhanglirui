package com.example.demoeurekaclient.design.Bridge;

/**
 * @author zhanglirui
 * @date 2020/11/16 5:48 下午
 */
public class ConcreteRemoteControl1 extends RemoteControl {

    public ConcreteRemoteControl1(TV tv) {
        super(tv);
    }

    @Override
    public void on() {
        System.out.println("ConcreteRemoteControl1.on()");
        tv.on();
    }

    @Override
    public void off() {
        System.out.println("ConcreteRemoteControl1.off()");
        tv.off();
    }

    @Override
    public void tuneChannel() {
        System.out.println("ConcreteRemoteControl1.tuneChannel()");
        tv.tuneChannel();
    }
}
