package com.example.demoeurekaclient.design.Builder;

/**
 * @author zhanglirui
 * @date 2020/11/16 1:51 下午
 */
public class StringBuilder extends AbstractStringBuilder {

    public StringBuilder() {
        super(16);
    }

    public StringBuilder(int capacity) {
        super(capacity);
    }

    @Override
    public String toString() {
        // Create a copy, don't share the array
        return new String(value, 0, count);
    }

}
