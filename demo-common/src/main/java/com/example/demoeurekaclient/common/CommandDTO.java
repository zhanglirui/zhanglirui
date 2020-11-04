package com.example.demoeurekaclient.common;

import java.io.Serializable;

/**
 * @author zhanglirui
 * @date 2020/11/4 3:51 下午
 */
public class CommandDTO implements Serializable {
    private static final long serialVersionUID = 8116415127446402655L;

    /**
     * 命名空间
     *
     */
    private Long namespace;

    /**
     *
     */
    private String sourceId;

    /**
     *
     */
    private String targetId;

    public Long getNamespace() {
        return namespace;
    }

    public void setNamespace(Long namespace) {
        this.namespace = namespace;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
}
