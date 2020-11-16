package com.example.demoeurekaclient.design.Prototype;

/**
 * @author zhanglirui
 * @date 2020/11/16 1:56 下午
 */
public class ConcretePrototype extends Prototype {

    private String filed;

    public ConcretePrototype(String filed) {
        this.filed = filed;
    }

    @Override
    Prototype myClone() {
        return new ConcretePrototype(filed);
    }

    @Override
    public String toString() {
        return filed;
    }
}
