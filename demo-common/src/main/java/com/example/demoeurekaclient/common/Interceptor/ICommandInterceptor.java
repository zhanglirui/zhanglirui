package com.example.demoeurekaclient.common.Interceptor;

import com.example.demoeurekaclient.common.CommandDTO;

/**
 * @author zhanglirui
 * @date 2020/11/4 4:07 下午
 */
public interface ICommandInterceptor {

    /**
     * before command execution
     * @param command
     */
    default void before(CommandDTO command) {

    }

    /**
     * after command execution
     * @param command
     * *//*
    default void after(CommandDTO command,BaseResult result) {

    }*/
}
