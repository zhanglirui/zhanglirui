package com.example.demoeurekaclient.design.Prototype;

/**
 * 原型设计模式
 * @author zhanglirui
 * @date 2020/11/16 1:58 下午
 */
public class Client {

    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype("abc");
        Prototype myClone = prototype.myClone();
        System.out.println(myClone.toString());
    }
}
