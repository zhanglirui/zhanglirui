package com.example.demoeurekaclient.design.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanglirui
 * @date 2020/11/16 4:54 下午
 */
public class CustomerGroup {

    private List<Customer> customers = new ArrayList<>();

    void accept(Visitor visitor) {
        for (Customer customer : customers) {
            customer.accept(visitor);
        }
    }

    void addCustomer(Customer customer) {
        customers.add(customer);
    }
}
