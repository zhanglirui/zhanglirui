package com.example.demoeurekaclient.common;

/**
 * @author zhanglirui
 * @date 2020/11/4 3:56 下午
 */
public class CommandException extends RuntimeException {

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }
}
