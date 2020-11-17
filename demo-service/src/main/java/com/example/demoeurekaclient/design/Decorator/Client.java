package com.example.demoeurekaclient.design.Decorator;

/**
 * 装修设计模式
 *
 * 为对象动态添加功能。
 *
 * 案列：设计不同种类的饮料，饮料可以添加配料，比如可以添加牛奶，并且支持动态添加新配料。每增加一种配料，该饮料的价格就会增加，要求计算一种饮料的价格。
 *
 * 下图表示在 DarkRoast 饮料上新增新添加 Mocha 配料，之后又添加了 Whip 配料。DarkRoast 被 Mocha 包裹，Mocha 又被 Whip 包裹。它们都继承自相同父类，都有 cost()
 * 方法，外层类的 cost() 方法调用了内层类的 cost() 方法。
 *
 * @author zhanglirui
 * @date 2020/11/17 11:14 上午
 */
public class Client {

    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();

        beverage = new Mocha(beverage);

        beverage = new Milk(beverage);

        System.out.println(beverage.cost());

    }
}
