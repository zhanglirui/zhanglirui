package com.example.demoeurekaclient.design.Composite;

/**
 * @author zhanglirui
 * @date 2020/11/17 10:31 上午
 */
public abstract class Component {

    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public void print() {
        print(0);
    }

    abstract void print(int level);

    abstract public void add(Component component);

    abstract public void remove(Component component);



}
