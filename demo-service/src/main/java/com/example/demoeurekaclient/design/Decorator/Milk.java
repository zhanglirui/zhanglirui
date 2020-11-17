package com.example.demoeurekaclient.design.Decorator;

/**
 * @author zhanglirui
 * @date 2020/11/17 11:11 上午
 */
public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + beverage.cost();
    }
}
