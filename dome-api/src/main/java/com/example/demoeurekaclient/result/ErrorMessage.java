package com.example.demoeurekaclient.result;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.ArrayUtils;

/**
 * @author zhanglirui
 * @date 2020/11/3 11:30 上午
 */
public class ErrorMessage {

    private String innerCode;
    private String displayMessage;
    private String readableCode;
    private String logMessage;
    private static final Map<String, ErrorMessage> NO_ARG_ERR_MSG_CACHE = new ConcurrentHashMap(100);
    public static String ILLEGAL_PARAM;
    public static String SUCCESS;
    public static String ERROR;

    public String getInnerCode() {
        return innerCode;
    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getReadableCode() {
        return readableCode;
    }

    public void setReadableCode(String readableCode) {
        this.readableCode = readableCode;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public static Map<String, ErrorMessage> getNoArgErrMsgCache() {
        return NO_ARG_ERR_MSG_CACHE;
    }

    public static String getIllegalParam() {
        return ILLEGAL_PARAM;
    }

    public static void setIllegalParam(String illegalParam) {
        ILLEGAL_PARAM = illegalParam;
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static void setSUCCESS(String SUCCESS) {
        ErrorMessage.SUCCESS = SUCCESS;
    }

    public static String getERROR() {
        return ERROR;
    }

    public static void setERROR(String ERROR) {
        ErrorMessage.ERROR = ERROR;
    }
}
