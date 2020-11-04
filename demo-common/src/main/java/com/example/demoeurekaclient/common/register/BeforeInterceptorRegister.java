package com.example.demoeurekaclient.common.register;

import java.util.List;

import javax.annotation.Resource;

import com.example.demoeurekaclient.common.CommandDTO;
import com.example.demoeurekaclient.common.CommandManager;
import com.example.demoeurekaclient.common.Interceptor.ICommandInterceptor;
import com.google.common.collect.ListMultimap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/11/4 11:56 上午
 */
@Component
public class BeforeInterceptorRegister extends AbstractRegister implements ApplicationContextAware {

    @Resource
    private CommandManager commandManager;

    @Override
    public void doRegister(Class<?> targetClass) {
        ICommandInterceptor interceptor = getBean(targetClass);
        BeforeInterceptor annotation = targetClass.getDeclaredAnnotation(BeforeInterceptor.class);
        Class<? extends CommandDTO>[] commands = annotation.commands();
        registerInterceptor(commands, interceptor);
    }

    private void registerInterceptor(Class<? extends CommandDTO>[] commands, ICommandInterceptor interceptor) {
        if(commands == null && commands.length == 0){
            List<ICommandInterceptor> globalBeforeInterceptors = commandManager.getGlobalBeforeInterceptors();
            globalBeforeInterceptors.add(interceptor);
            order(globalBeforeInterceptors);
            return;
        }
        for (Class<? extends CommandDTO> supportClass:commands) {
            ListMultimap<Class, ICommandInterceptor> beforeInterceptors = commandManager.getBeforeInterceptors();
            beforeInterceptors.put(supportClass,interceptor);
            //order(beforeInterceptors);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}
