package com.example.demoeurekaclient.design.templateMethod;

/**
 * @author zhanglirui
 * @date 2020/11/16 4:26 下午
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Tea.brew");
    }

    @Override
    void addCondiments() {
        System.out.println("Tea.addCondiments");
    }
}
