package com.example.demoeurekaclient.design.Builder;

/**
 * 生成器设计模式
 * @author zhanglirui
 * @date 2020/11/16 1:52 下午
 */
public class Client {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        final int count = 26;
        for (int i = 0; i < count; i++) {
            sb.append((char) ('a' + i));
        }
        System.out.println(sb.toString());
    }
}
