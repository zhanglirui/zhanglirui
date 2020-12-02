package com.example.demoeurekaclient;

import javax.annotation.Resource;

import com.example.demoeurekaclient.ScheduledTasks.ScheduledTasks;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhanglirui
 * @date 2020/12/1 3:10 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduledTasksTest {

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Test
    public void reportCurrentTime() {

        scheduledTasks.reportCurrentTime();
    }
}