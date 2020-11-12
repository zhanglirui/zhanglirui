package com.example.demoeurekaclient.spring.extend;

import com.example.demoeurekaclient.entry.ItemObject;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/11/10 5:45 下午
 */
@Component
public class TestFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new ItemObject();
    }

    @Override
    public Class<?> getObjectType() {
        return ItemObject.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
