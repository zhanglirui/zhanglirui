package com.example.demoeurekaclient.design.Facade;

/**
 * 外观设计模式
 *
 * 提供了一个统一的接口，用来访问子系统中的一群接口，从而让子系统更容易使用。
 *
 * 案列：观看电影需要操作很多电器，使用外观模式实现一键看电影功能。
 *
 * 设计原则：最少知识原则：只和你的密友谈话。也就是说客户对象所需要交互的对象应当尽可能少。
 *
 *
 *
 * @author zhanglirui
 * @date 2020/11/17 11:36 上午
 */
public class Client {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.watchMovie();
    }


}
