package com.example.demoeurekaclient.design.Iterator;

/**
 * @author zhanglirui
 * @date 2020/11/16 2:46 下午
 */
public interface Iterator<Item> {

    Item next();

    boolean hasNext();
}
