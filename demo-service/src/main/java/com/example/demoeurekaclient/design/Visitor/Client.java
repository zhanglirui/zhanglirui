package com.example.demoeurekaclient.design.Visitor;

/**
 * 访问者设计模式
 *
 * 为一个对象结构（比如组合结构）增加新能力
 *
 * 案列：客户组里包含客户，客户包含订单，订单包含商品
 * @author zhanglirui
 * @date 2020/11/16 4:51 下午
 */
public class Client {

    public static void main(String[] args) {
        Customer customer1 = new Customer("customer1");
        customer1.addOrder(new Order("order1", "item1"));
        customer1.addOrder(new Order("order2", "item1"));
        customer1.addOrder(new Order("order3", "item1"));

        Order order = new Order("order_a");
        order.addItem(new Item("item_a1"));
        order.addItem(new Item("item_a2"));
        order.addItem(new Item("item_a3"));

        Customer customer2 = new Customer("customer2");
        customer2.addOrder(order);

        CustomerGroup customers = new CustomerGroup();
        customers.addCustomer(customer1);
        customers.addCustomer(customer2);

        GeneralReport visitor = new GeneralReport();
        customers.accept(visitor);
        visitor.displayResults();
    }
}
