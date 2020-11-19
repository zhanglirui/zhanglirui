package com.example.demoeurekaclient.example;

/**
 * 1．默认方法使用 default 关键字，一个接口中可以有多个默认方法。
 * 2．接口中既可以定义抽象方法，又可以定义默认方法，默认方法不是抽象方法。
 * 3．子类实现接口的时候，可以直接调用接口中的默认方法，即继承了接口中的默认方法。
 * 4．接口中同时还可以定义静态方法，静态方法通过接口名调用。
 *
 * @author zhanglirui
 * @date 2020/11/17 4:47 下午
 */
public interface Cat {

    /**
     * 抽象方法
     */
    void play();

    /* // 静态方法
    static void eat() {
        System.out.println("猫吃鱼");
    }
​
    // 默认方法​
    default void run() {
        System.out.println("猫跑");
    }
​
   // 默认方法
    default void climb() {
        System.out.println("猫爬树");​
    }*/


}
