package com.example.demoeurekaclient.design.simplefFactory;

/**
 * 简单工厂模式
 * @author zhanglirui
 * @date 2020/11/16 11:44 上午
 */
public class Client {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
    }
}
