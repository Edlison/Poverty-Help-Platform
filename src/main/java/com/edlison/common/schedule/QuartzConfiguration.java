package com.edlison.common.schedule;

import com.edlison.marketing.mapper.CronMapper;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * QuartzConfiguration
 *
 * @Author Edlison
 * @Date 1/22/21 11:42
 */
@Configuration
public class QuartzConfiguration {
    // 指定定时任务类
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(QuartzJob.class).withIdentity("QuartzJob").storeDurably().build();
    }

    @Autowired
    CronMapper cronMapper;

    @Bean
    public Trigger uploadTaskTrigger() {
        String cron = cronMapper.selectCron(1);

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);

        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail()).withIdentity("QuartzJob").withSchedule(cronScheduleBuilder).build();
    }
}
