package com.example.demoeurekaclient;

import com.example.demoeurekaclient.result.BaseResult;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author zhanglirui
 * @date 2020/11/3 11:52 上午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes = DemoStartApplication.class)
public class UserStatusControllerTest {

    @Autowired
    private UserStatusController userStatusController;

    @Test
    public void userStatusCreateTest1() {

        BaseResult baseResult = userStatusController.userStatusCreate(1, "zhang lirui 123");

        Assert.assertTrue(baseResult.isSuccess());
    }

    @Test
    public void userStatusCreateTest2() {

        BaseResult baseResult = userStatusController.userStatusCreate(2, "zhang lirui 123");

        Assert.assertTrue(baseResult.isSuccess());
    }
}