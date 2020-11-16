package com.example.demoeurekaclient.design.simplefFactory;

/**
 * @author zhanglirui
 * @date 2020/11/16 11:44 上午
 */
public class SimpleFactory {

    public Product createProduct(int type) {
        if (type == 1) {
            return new ConcreteProduct1();
        } else if (type == 2) {
            return new ConcreteProduct2();
        }
        return new ConcreteProduct();
    }
}
