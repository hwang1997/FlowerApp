package com.mis.flowers.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 文件上传/下载工具类
 *
 */
public class AppFileUtils {
    //文件上传的保存路径
    public static String UPLOAD_PATH="D:/biye/upload";
    public static String IMAGES_DEFAULTGOODSIMG_PNG = "images/1.png";
    static {
        //读取配置文件的存储地址
       InputStream stream = AppFileUtils.class.getClassLoader().getResourceAsStream("file.properties");
        Properties properties = new Properties();
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String property = properties.getProperty("filepath");
        if (property != null){
            UPLOAD_PATH = property;
        }

    }
    /**
     * 根据文件老名得到新名字
     */
    public static String createNewFileName(String oldName) {
        String stuff = oldName.substring(oldName.lastIndexOf("."),oldName.length());

        return IdUtil.simpleUUID().toUpperCase() + stuff;
    }

    //文件下载
    public static ResponseEntity<Object> createResponseEntity(String path) {
        //1、构造文件对象
        File file = new File(UPLOAD_PATH,path);
        if (file.exists()){
            //将下载的文件封装成byte[]
            byte[] bytes = null;
            try {
                bytes = FileUtil.readBytes(file);
            }catch (Exception e){
                e.printStackTrace();
            }
            //创建封装响应头信息的对象
            HttpHeaders header = new HttpHeaders();
            //封装响应内容类型（APPLICATION_OCTET_STREAM）
            header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //设置下载文件名称
//            header.setContentDispositionFormData("attachment","123.jpg");
            //创建ResponseEntity对象
            ResponseEntity<Object> entity = new ResponseEntity<Object>(bytes, header, HttpStatus.CREATED);

            return entity;
        }
        return null;
    }

    //根据路径改名字，取得_temp
    public static String renameFile(String goodsimg) {
        File file = new File(UPLOAD_PATH, goodsimg);
        String replace = goodsimg.replace("_temp","");
        if (file.exists()){
            file.renameTo(new File(UPLOAD_PATH, replace));
        }
        return replace;
    }
    //根据老路径删除图片
    public static void removeFileByPath(String oldPath) {
        if (oldPath.equals(IMAGES_DEFAULTGOODSIMG_PNG)){
            File file = new File(UPLOAD_PATH, oldPath);
            if (file.exists()){
                file.delete();
            }
        }

    }
}
