package com.example.demoeurekaclient.entry;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/9/24 1:48 下午
 */
@Component
public class MyObj implements Serializable {
    private static final long serialVersionUID = -473505244891513683L;

    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


}
