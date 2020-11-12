package com.example.demoeurekaclient;

import java.util.Date;

import com.example.demoeurekaclient.entry.ItemObject;
import com.example.demoeurekaclient.entry.UserInfoQuery;
import com.example.demoeurekaclient.impl.UserInfoServiceImpl;
import com.example.demoeurekaclient.spring.extend.TestFactoryBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhanglirui
 * @date 2020/11/11 10:08 上午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoStartApplication.class)
public class TestFactoryBeanTest {

    @Autowired
    private TestFactoryBean testFactoryBean;

    @Test
    public void getObject() throws Exception {
        ItemObject object = (ItemObject)testFactoryBean.getObject();
        Assert.assertNotNull(object);
    }


    @Test
    public void getObjectType() {
    }

    @Test
    public void isSingleton() {
    }

    @Test
    public void test() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring/spring-manager.xml");
        System.out.println("number : " + ctx.getBeanDefinitionCount());

        UserInfoQuery query = new UserInfoQuery();
        query.setStatus(1);
        query.setCreateUser("qazwsx");
        query.setGmtCreate(new Date());

        ((UserInfoServiceImpl) ctx.getBean("userInfoServiceImpl")).saveObject(query);
    }
}