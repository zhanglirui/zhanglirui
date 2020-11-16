package com.example.demoeurekaclient.design.Iterator;

/**
 * @author zhanglirui
 * @date 2020/11/16 2:49 下午
 */
public class ConcreteIterator<Item> implements Iterator{

    private Item[] items;
    private int position = 0;

    public ConcreteIterator(Item[] items) {
        this.items = items;
    }


    @Override
    public Object next() {
        return items[position++];
    }

    @Override
    public boolean hasNext() {
        return position < items.length;
    }
}
