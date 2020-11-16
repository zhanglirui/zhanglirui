package com.example.demoeurekaclient.design.factoryMethod;

import com.example.demoeurekaclient.design.simplefFactory.ConcreteProduct2;
import com.example.demoeurekaclient.design.simplefFactory.Product;

/**
 * @author zhanglirui
 * @date 2020/11/16 11:47 上午
 */
public class ConcreteFactory2 extends  Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}
