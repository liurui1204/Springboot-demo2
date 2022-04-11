package com.LiuR.springboot.config;

import com.LiuR.springboot.quartz.QuartzDemo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@EnableScheduling
@Configuration
public class QuartzConfig {
    /**
     * 1.创建Job对象
     * @return
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();

        //关联自己的任务类
        factoryBean.setJobClass(QuartzDemo.class);
        return factoryBean;
    }

    /**
     * 创建trigger对象，简单的trigger
     * @param jobDetailFactoryBean
     * @return
     */
    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean triggerFactoryBean = new SimpleTriggerFactoryBean();
        //关联JobDetail对象
        triggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //设置触发时间
        triggerFactoryBean.setRepeatInterval(2000);
        //设置重复次数
        triggerFactoryBean.setRepeatInterval(10);
        return triggerFactoryBean;
    }

    /**
     *
     * @param simpleTriggerFactoryBean
     * @return
     */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //关联trigger
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
        return schedulerFactoryBean;
    }
}
