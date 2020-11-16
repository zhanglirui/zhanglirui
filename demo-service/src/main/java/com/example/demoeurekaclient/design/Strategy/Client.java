package com.example.demoeurekaclient.design.Strategy;

/**
 * 策略设计模式
 *
 * 定义一系列算法，封装每个算法，并使它们可以互换。
 *
 * 策略模式可以让算法独立于使用它的客户端。
 *
 * 案列：设计一个鸭子，它可以动态地改变叫声。这里的算法族是鸭子的叫声行为。
 * @author zhanglirui
 * @date 2020/11/16 4:17 下午
 */
public class Client {

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setQuackBehavior(new Squeak());
        duck.performQuack();
        duck.setQuackBehavior(new Quack());
        duck.performQuack();
    }
}
