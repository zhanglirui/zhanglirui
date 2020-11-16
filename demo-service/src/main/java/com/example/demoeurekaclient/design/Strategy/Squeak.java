package com.example.demoeurekaclient.design.Strategy;

/**
 * @author zhanglirui
 * @date 2020/11/16 4:15 下午
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}
