package org.layz.hx.biz.task.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
@Service
public class TaskTest {
private static final Logger logger = Logger.getLogger(TaskTest.class);
	
	@Scheduled(cron="0/10 * * * * ?") //使用cron表达式，每3秒钟执行一次
    public void checkTaskRules(){
        logger.info("定时任务雏形=======" + new Date());
    }
}
