package com.example.demoeurekaclient.design.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglirui
 * @date 2020/11/16 4:43 下午
 */
public class Order implements Element {

    private String name;
    private List<Item> items = new ArrayList();

    public Order(String name) {
        this.name = name;
    }

    Order(String name, String itemName) {
        this.name = name;
        this.addItem(new Item(itemName));
    }

    public String getName() {
        return name;
    }

    void addItem(Item item) {
        items.add(item);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Item item : items) {
            item.accept(visitor);
        }
    }
}
