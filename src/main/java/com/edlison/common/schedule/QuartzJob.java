package com.edlison.common.schedule;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * QuartzJob
 *
 * @Author Edlison
 * @Date 1/22/21 11:39
 */
public class QuartzJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext){
        // 定时任务内容
        System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime());
    }
}
