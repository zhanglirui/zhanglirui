package com.example.demoeurekaclient.module;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhanglirui
 * @date 2020/10/28 7:40 下午
 */
public class UserInfoDO implements Serializable {
    private static final long serialVersionUID = -7602164341685638527L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 游戏ID
     */
    private Long gameId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
