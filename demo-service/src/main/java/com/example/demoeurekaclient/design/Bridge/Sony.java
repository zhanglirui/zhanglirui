package com.example.demoeurekaclient.design.Bridge;

/**
 * @author zhanglirui
 * @date 2020/11/16 5:45 下午
 */
public class Sony extends TV {
    @Override
    public void on() {
        System.out.println("Sony.on()");
    }

    @Override
    public void off() {
        System.out.println("Sony.off()");
    }

    @Override
    public void tuneChannel() {
        System.out.println("Sony.tuneChannel()");
    }
}
