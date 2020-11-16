package com.example.demoeurekaclient.design.Chain;

/**
 * @author zhanglirui
 * @date 2020/11/16 11:02 上午
 */
public enum RequestType {

    /**
     * 类型1
     */
    TYPE1(1,"类型1"),
    /**
     * 类型2
     */
    TYPE2(2,"类型2");

    RequestType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private Integer value;

    private String desc;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
