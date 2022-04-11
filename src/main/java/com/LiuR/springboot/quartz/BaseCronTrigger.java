package com.LiuR.springboot.quartz;

import org.quartz.JobDetail;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.support.CronTrigger;

import java.io.Serializable;

public abstract class BaseCronTrigger extends CronTriggerFactoryBean implements Serializable {
    public void init(){
        //得到任务
        
    }
}
