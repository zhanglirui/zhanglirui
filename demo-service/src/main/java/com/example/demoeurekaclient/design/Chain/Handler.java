package com.example.demoeurekaclient.design.Chain;

/**
 * @author zhanglirui
 * @date 2020/11/16 10:55 上午
 */
public abstract class Handler {

    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }


    protected abstract void handleRequest(Request request);

}
