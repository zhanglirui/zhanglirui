package com.example.demoeurekaclient.design.abstractFactory;

/**
 * @author zhanglirui
 * @date 2020/11/16 11:28 上午
 */
public class ConcreteFactory1 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB1();
    }
}
