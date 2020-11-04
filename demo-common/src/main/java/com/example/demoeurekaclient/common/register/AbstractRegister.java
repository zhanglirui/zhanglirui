package com.example.demoeurekaclient.common.register;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author zhanglirui
 * @date 2020/11/4 11:57 上午
 */
public abstract class AbstractRegister implements Iregister,ApplicationContextAware {

    protected ApplicationContext applicationContext;

    /**
     * 获取容器的指定对象
     * @param targetClz
     * @param <T>
     * @return
     */
    protected<T> T getBean(Class targetClz){
        T beanInstance = null;
        //优先按type查
        try {
            beanInstance = (T)applicationContext.getBean(targetClz);
        }catch (Exception e){
        }

        if(beanInstance == null ){
            // 获取类名，首字母小写
            String simpleName = targetClz.getSimpleName();
            simpleName = Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
            beanInstance =(T)applicationContext.getBean(simpleName);
        }

        if(beanInstance == null ){
            new RuntimeException("Component " + targetClz + " can not be found in Spring Container");
        }

        return beanInstance;
    }

    /**
     * 拦截器 根据Order注解排序
     * @param
     */
    protected <T> void order(List<T> interceptorIList){
        if(interceptorIList == null || interceptorIList.size() <= 1){
            return;
        }
        T newInterceptor = interceptorIList.get(interceptorIList.size() - 1);
        Order order = newInterceptor.getClass().getDeclaredAnnotation(Order.class);
        if(order == null){
            return;
        }
        int index = interceptorIList.size() - 1;
        for(int i = interceptorIList.size() - 2; i >= 0; i--){
            int itemOrderInt = Ordered.LOWEST_PRECEDENCE;
            Order itemOrder = interceptorIList.get(i).getClass().getDeclaredAnnotation(Order.class);
            if(itemOrder != null){
                itemOrderInt = itemOrder.value();
            }
            if(itemOrderInt > order.value()){
                interceptorIList.set(index, interceptorIList.get(i));
                index = i;
            }else {
                break;
            }
        }
        if(index < interceptorIList.size() - 1){
            interceptorIList.set(index, newInterceptor);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

}
