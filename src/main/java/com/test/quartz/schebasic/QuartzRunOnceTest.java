package com.test.quartz.schebasic;

import com.test.quartz.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.DateBuilder.futureDate;

/**
 * @author szh
 * @date  2017-11-30
 * Created by szh on 2017/11/30.
 */
public class QuartzRunOnceTest implements  Runnable{

    @Override
    public void run(){
        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // define the job and tie it to our HelloJob class
            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .usingJobData("name", "quartzRunOnce") //定义属性
                    .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startAt(futureDate(5, DateBuilder.IntervalUnit.SECOND))
                    .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);

            // and start it off
            scheduler.start();

            Thread.sleep(100000000000000L);
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread quartzRunOnceTest = new Thread(new QuartzRunOnceTest());
        quartzRunOnceTest.start();
    }
}
