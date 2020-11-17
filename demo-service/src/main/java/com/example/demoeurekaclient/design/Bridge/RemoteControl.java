package com.example.demoeurekaclient.design.Bridge;

/**
 * @author zhanglirui
 * @date 2020/11/16 5:48 下午
 */
public abstract class RemoteControl {

    protected TV tv;

    public RemoteControl(TV tv) {
        this.tv = tv;
    }

    public abstract void on();

    public abstract void off();

    public abstract void tuneChannel();
}
