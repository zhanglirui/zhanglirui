package com.example.demoeurekaclient.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglirui
 * @date 2020/11/3 11:27 上午
 */
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = -8056366594140375207L;

    private String traceId;

    private boolean success = true;

    private String innerCode;

    private String resultCode;

    private String resultMsg;

    private Map<String, Object> extra = new HashMap();

    private T data;

    public BaseResult() {
    }

    public BaseResult(boolean success, String innerCode, String resultCode, String resultMsg) {
        this.success = success;
        this.innerCode = innerCode;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
