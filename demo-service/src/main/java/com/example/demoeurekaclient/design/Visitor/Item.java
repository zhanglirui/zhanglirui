package com.example.demoeurekaclient.design.Visitor;

/**
 * @author zhanglirui
 * @date 2020/11/16 4:44 下午
 */
public class Item implements Element {

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
