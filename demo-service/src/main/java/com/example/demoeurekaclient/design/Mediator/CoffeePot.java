package com.example.demoeurekaclient.design.Mediator;

/**
 * @author zhanglirui
 * @date 2020/11/16 3:06 下午
 */
public class CoffeePot extends Colleague {


    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("coffeePot");
    }

    public void doCoffeePot() {
        System.out.println("doCoffeePot()");
    }
}
