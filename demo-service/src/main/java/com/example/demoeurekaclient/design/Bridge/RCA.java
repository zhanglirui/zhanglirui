package com.example.demoeurekaclient.design.Bridge;

/**
 * @author zhanglirui
 * @date 2020/11/16 5:46 下午
 */
public class RCA extends TV {
    @Override
    public void on() {
        System.out.println("RCA.on()");
    }

    @Override
    public void off() {
        System.out.println("RCA.off()");
    }

    @Override
    public void tuneChannel() {
        System.out.println("RCA.tuneChannel()");
    }
}
