package com.wanghuan.login.test;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpConnectionUtils {
    public static HttpURLConnection getConnection(String data)throws Exception{
        URL url = new URL("http://192.168.0.120:8090/shop/AdminLogin");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setReadTimeout(5000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Length",data.length()+"");
        OutputStream outputStream =connection.getOutputStream();
        outputStream.write(data.getBytes());
        return connection;
    }
}
