package com.example.demoeurekaclient.design.templateMethod;

/**
 * @author zhanglirui
 * @date 2020/11/16 4:25 下午
 */
public class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Coffee.brew");
    }

    @Override
    void addCondiments() {
        System.out.println("Coffee.addCondiments");
    }
}
