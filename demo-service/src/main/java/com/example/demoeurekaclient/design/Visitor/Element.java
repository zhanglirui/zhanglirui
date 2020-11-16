package com.example.demoeurekaclient.design.Visitor;

/**
 * @author zhanglirui
 * @date 2020/11/16 4:42 下午
 */
public interface Element {

    void accept(Visitor visitor);
}
