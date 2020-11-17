package com.example.demoeurekaclient.design.Adapter;

/**
 * @author zhanglirui
 * @date 2020/11/16 5:17 下午
 */
public class TurkeyAdapter implements Duck{

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}
