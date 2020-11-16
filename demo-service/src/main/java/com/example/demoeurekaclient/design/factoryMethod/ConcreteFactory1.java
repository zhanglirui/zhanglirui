package com.example.demoeurekaclient.design.factoryMethod;

import com.example.demoeurekaclient.design.simplefFactory.ConcreteProduct1;
import com.example.demoeurekaclient.design.simplefFactory.Product;

/**
 * @author zhanglirui
 * @date 2020/11/16 11:46 上午
 */
public class ConcreteFactory1 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
