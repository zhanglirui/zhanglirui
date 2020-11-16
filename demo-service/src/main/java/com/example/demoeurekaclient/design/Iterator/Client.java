package com.example.demoeurekaclient.design.Iterator;

/**
 * 迭代器设计模式
 * @author zhanglirui
 * @date 2020/11/16 2:53 下午
 */
public class Client {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
