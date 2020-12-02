package com.example.demoeurekaclient.ScheduledTasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhanglirui
 * @date 2020/12/1 3:04 下午
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * @Scheduled（fixedRate = 5000）：上一次开始执行时间点之后5秒再执行
     * @Scheduled（fixedDelay = 5000）：上一次执行完成时间点之后5秒再执行
     * @Scheduled（ini​​tialDelay = 1000，fixedRate = 5000）：第一次重复1秒后执行，之后按fixedRate的规则每5秒执行一次
     * @Scheduled（cron =” / 5“）：通过cron表达定义规则，什么是cro表达，自行搜索引擎。
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {} -------定时任务测试", dateFormat.format(new Date()));
    }
}
