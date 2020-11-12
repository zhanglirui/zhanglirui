package com.example.demoeurekaclient.entry;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhanglirui
 * @date 2020/11/9 8:25 下午
 */
public class ItemObject implements Serializable {
    private static final long serialVersionUID = 3938885922122064440L;

    /**
     * id
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 昵称
     */
    private String nick;

    /**
     * 价格
     */
    private String pric;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPric() {
        return pric;
    }

    public void setPric(String pric) {
        this.pric = pric;
    }

    @Autowired
    public ItemObject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ItemObject() {
    }
}
