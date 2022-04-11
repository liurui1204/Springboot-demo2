package com.LiuR.springboot.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TestJob {
    public static void main(String[] args) throws SchedulerException {
        //Job封装成JobDetail设置属性
        JobDetail jobDetail = JobBuilder.newJob(QuartzDemo.class)
                .withIdentity("job1","group1")
                .build();

        //触发器，指定执行时间、开始结束时间
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();
        //调度器：基于trigger的设定执行job
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
        //JobDataMap：保存任务实例的状态信息
    }
}
