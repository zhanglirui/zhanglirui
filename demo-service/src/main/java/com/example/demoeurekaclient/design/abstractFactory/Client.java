package com.example.demoeurekaclient.design.abstractFactory;

/**
 * 抽象工厂模式
 * @author zhanglirui
 * @date 2020/11/16 11:30 上午
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.createProductA();
        AbstractProductB productB = abstractFactory.createProductB();

        ConcreteFactory2 concreteFactory2 = new ConcreteFactory2();
        AbstractProductA productA2 = concreteFactory2.createProductA();
        concreteFactory2.createProductB();
    }
}
