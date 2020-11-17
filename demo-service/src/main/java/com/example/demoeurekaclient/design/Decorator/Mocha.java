package com.example.demoeurekaclient.design.Decorator;

/**
 * @author zhanglirui
 * @date 2020/11/17 11:13 上午
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + beverage.cost();
    }
}
