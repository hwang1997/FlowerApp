package com.mis.flowers.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.mis.flowers.util.AppFileUtils.removeFileByTimer;

//@Configuration          //证明这个类是一个配置文件
@Component
public class mytimer {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    //每隔2秒执行一次
//    @Scheduled(fixedRate = 2000)
//    public void testTasks() {
//        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
//    }
    //每天23：59执行
    @Scheduled(cron = "0 59 23 ? * *")
    public void testTasks1() {
        removeFileByTimer();
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
    }
}

