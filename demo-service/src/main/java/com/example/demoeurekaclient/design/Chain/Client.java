package com.example.demoeurekaclient.design.Chain;

/**
 * 责任链设计模式
 * @author zhanglirui
 * @date 2020/11/16 11:07 上午
 */
public class Client {

    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);

        Request request1 = new Request(RequestType.TYPE1, "request1");
        handler2.handleRequest(request1);

        Request request2 = new Request(RequestType.TYPE2, "request2");
        handler2.handleRequest(request2);
    }
}
