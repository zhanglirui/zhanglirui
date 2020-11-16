package com.example.demoeurekaclient.design.Visitor;

/**
 * @author zhanglirui
 * @date 2020/11/16 4:42 下午
 */
public interface Visitor {

    void visit(Customer customer);

    void visit(Order order);

    void visit(Item item);
}
