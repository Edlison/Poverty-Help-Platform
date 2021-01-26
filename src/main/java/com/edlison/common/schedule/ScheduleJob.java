//package com.edlison.common.schedule;
//
//import com.edlison.marketing.mapper.CronMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//
//import java.time.LocalDateTime;
//
///**
// * Job
// *
// * @Author Edlison
// * @Date 1/22/21 10:13
// */
//@Configuration
//@EnableScheduling
//public class ScheduleJob implements SchedulingConfigurer {
//
//    @Autowired
//    CronMapper cronMapper;
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
//        scheduledTaskRegistrar.addTriggerTask(
//                //1.添加任务内容(Runnable)
//                () -> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
//                //2.设置执行周期(Trigger)
//                triggerContext -> {
//                    //2.1 从数据库获取执行周期
//                    String cron = cronMapper.selectCron(1);
//                    //2.2 合法性校验.
//                    if (cron == null || cron.equals("")) {
//                        // Omitted Code ..
//                        System.out.println("error");
//                        return null;
//                    }
//                    //2.3 返回执行周期(Date)
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                }
//        );
//    }
//}