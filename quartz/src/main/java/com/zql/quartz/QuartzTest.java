package com.zql.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.GregorianCalendar;

import static org.quartz.DateBuilder.newDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzTest {
    public static void main(String[] args) {
        try {
            // 创建scheduler（调度器）
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // 定义的排除时间
            AnnualCalendar calendar = new AnnualCalendar();
            GregorianCalendar exclude = new GregorianCalendar();
            exclude.setTime(newDate().inMonthOnDay(10,25).build());
            calendar.setDayExcluded(exclude,true);
            scheduler.addCalendar("myCalendar",calendar,false,false);

            // 定义Trigger(触发器)
            SimpleTrigger trigger = newTrigger().withIdentity("trigger1", "group1")  //定义name和group
                    .startNow()     // 立即生效
                    .modifiedByCalendar("myCalendar")   // 设置排除的calendar
                    .withSchedule(simpleSchedule()  // 使用simpleSchedule
                            .withIntervalInSeconds(1)   // 1秒执行一次
                            .withIntervalInMinutes(1)   // 1分钟执行一次
                            .withRepeatCount(10)    // 次数为10次
                            .repeatForever())    // 一直执行
                    .build();

            // 定义一个JobDetail
            JobDetail jobDetail = newJob(HelloQuartz.class)       // 定义job类未HelloQuartz，这是真正的执行逻辑
                    .withIdentity("job1", "group1")  // 定义name和group
                    .usingJobData("name", "quartz")  // 定义属性
                    .build();

            // 将任务加入调度
            scheduler.scheduleJob(jobDetail,trigger);

            // 启动调度器
            scheduler.start();

            // 运行一段时间后关闭
            Thread.sleep(10000);
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
