package com.mis.flowers.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ordersIdUtil {
    public static String getOrderId(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        //获取5位随机数
        int rannum = (int) (random.nextDouble() * (99999 - 10000 +1)) + 10000;
        return str + rannum;
    }
}
