package com.example.demoeurekaclient.context;

import java.util.Map;

import com.example.demoeurekaclient.UserStatusService;
import com.example.demoeurekaclient.annotion.MyAnnotation;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/11/3 10:54 上午
 */
@Component
public class UserStatusServiceListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(MyAnnotation.class);

        UserStatusServiceContext context = event.getApplicationContext().getBean(UserStatusServiceContext.class);

        beans.forEach((name, bean) ->{
            MyAnnotation annotation = bean.getClass().getAnnotation(MyAnnotation.class);
            context.putUserStatusService(annotation.type().toNumericValue(),(UserStatusService)bean);
        } );

    }
}
