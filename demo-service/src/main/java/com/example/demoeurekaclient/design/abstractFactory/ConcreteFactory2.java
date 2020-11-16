package com.example.demoeurekaclient.design.abstractFactory;

/**
 * @author zhanglirui
 * @date 2020/11/16 11:29 上午
 */
public class ConcreteFactory2 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB2();
    }
}
