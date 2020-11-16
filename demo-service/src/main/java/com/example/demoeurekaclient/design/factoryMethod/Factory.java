package com.example.demoeurekaclient.design.factoryMethod;

import com.example.demoeurekaclient.design.simplefFactory.Product;

/**
 * @author zhanglirui
 * @date 2020/11/16 11:45 上午
 */
public abstract class Factory {
    abstract public Product factoryMethod();
    public void doSomething() {
        Product product = factoryMethod();
        // do something with the product
    }
}
