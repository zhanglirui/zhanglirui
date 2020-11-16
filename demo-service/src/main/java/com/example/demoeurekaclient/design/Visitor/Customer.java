package com.example.demoeurekaclient.design.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglirui
 * @date 2020/11/16 4:43 下午
 */
public class Customer implements Element {

    private String name;
    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    void addOrder(Order order) {
        orders.add(order);
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Order order:orders) {
            order.accept(visitor);
        }
    }
}
