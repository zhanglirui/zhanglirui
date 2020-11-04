package com.example.demoeurekaclient.common;

import java.util.ArrayList;
import java.util.List;

import com.example.demoeurekaclient.common.Interceptor.ICommandInterceptor;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/11/4 4:05 下午
 */
@Component
public class CommandManager {

    // TODO
    private ListMultimap<Class/*CommandClz*/, ICommandInterceptor> beforeInterceptors = LinkedListMultimap.create();

    /**
     * 全局通用的beforeInterceptors
     */
    private List<ICommandInterceptor> globalBeforeInterceptors = new ArrayList<>();

    public ListMultimap<Class, ICommandInterceptor> getBeforeInterceptors() {
        return beforeInterceptors;
    }

    public void setBeforeInterceptors(
        ListMultimap<Class, ICommandInterceptor> beforeInterceptors) {
        this.beforeInterceptors = beforeInterceptors;
    }

    public List<ICommandInterceptor> getGlobalBeforeInterceptors() {
        return globalBeforeInterceptors;
    }

    public void setGlobalBeforeInterceptors(
        List<ICommandInterceptor> globalBeforeInterceptors) {
        this.globalBeforeInterceptors = globalBeforeInterceptors;
    }
}
