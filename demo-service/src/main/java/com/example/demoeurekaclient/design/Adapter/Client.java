package com.example.demoeurekaclient.design.Adapter;

/**
 * 适配器设计模式
 *
 * 把一个类接口转换成另一个用户需要的接口。
 *
 * 案列：鸭子（Duck）和火鸡（Turkey）拥有不同的叫声，Duck 的叫声调用 quack() 方法，而 Turkey 调用 gobble() 方法。
 *
 *      要求将 Turkey 的 gobble() 方法适配成 Duck 的 quack() 方法，从而让火鸡冒充鸭子！
 *
 *
 * @author zhanglirui
 * @date 2020/11/16 5:18 下午
 */
public class Client {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        Duck duck = new TurkeyAdapter(turkey);
        duck.quack();
    }
}
