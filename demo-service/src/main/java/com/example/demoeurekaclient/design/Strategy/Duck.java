package com.example.demoeurekaclient.design.Strategy;

/**
 * @author zhanglirui
 * @date 2020/11/16 4:16 下午
 */
public class Duck {

    private QuackBehavior quackBehavior;

    public void performQuack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
