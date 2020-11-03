package com.example.demoeurekaclient;

import java.util.Date;

import com.example.demoeurekaclient.entry.UserInfoQuery;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author zhanglirui
 * @date 2020/10/28 8:15 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = DemoStartApplication.class)
@TestPropertySource(properties = "classpath:application.properties")
public class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void saveObject() {
        UserInfoQuery query = new UserInfoQuery();
        query.setCreateUser("测试用户");
        query.setGmtCreate(new Date());
        query.setGameId(1L);
        query.setStatus(1);
        int i = userInfoService.saveObject(query);
        Assert.assertNotNull(i);
    }
}