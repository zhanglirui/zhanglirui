package com.example.demoeurekaclient.design.Iterator;

/**
 * @author zhanglirui
 * @date 2020/11/16 2:47 下午
 */
public class ConcreteAggregate implements Aggregate {

    private Integer[] items;

    public ConcreteAggregate() {
        items = new Integer[10];
        for (int i = 0; i < items.length; i++) {
            items[i] = i;
        }
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator<Integer>(items);
    }
}
