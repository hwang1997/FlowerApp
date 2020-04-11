package com.mis.flowers.util;

import java.security.MessageDigest;

public class MD5Util {
    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        //MessageDigest对象接收任意大小数据，并输出固定长度的希哈值
        try {
            md5 = MessageDigest.getInstance("md5");
            //对getInstance对象初始化，设定为MD5算法
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";	//失败时返回空字符串
        }
        //将需要加密的字段转化为字节数组，指定UTF-8编码格式
        byte[] byteArray = inStr.getBytes("UTF-8");
        //使用填充式操作完成哈希计算
        byte[] md5Bytes = md5.digest(byteArray);
        //定义一个StringBuffer来存储加密字符
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            //转换为十六进制存储到StringBuffer中
            hexValue.append(Integer.toHexString(val));
        }
        //返回经过MD5加密后的密文
        return hexValue.toString();

    }
}
