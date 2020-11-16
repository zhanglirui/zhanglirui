package com.example.demoeurekaclient.design.Mediator;

/**
 * @author zhanglirui
 * @date 2020/11/16 3:07 下午
 */
public class Sprinkler extends Colleague {
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("sprinkler");
    }

    public void doSprinkler() {
        System.out.println("doSprinkler()");
    }
}
