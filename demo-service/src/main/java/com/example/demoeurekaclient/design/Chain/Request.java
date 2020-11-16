package com.example.demoeurekaclient.design.Chain;

/**
 * @author zhanglirui
 * @date 2020/11/16 10:56 上午
 */
public class Request {

    private RequestType type;
    private String name;


    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }


    public RequestType getType() {
        return type;
    }


    public String getName() {
        return name;
    }

}
