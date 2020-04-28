package com.wanghuan.login.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ordersIdUtil {
    public static String getOrderId(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        //获取5位随机数
        int rannum = (int) (random.nextDouble() * (999 - 100 +1)) + 100;
        String orderId = str + rannum;
        return orderId;
    }
}
