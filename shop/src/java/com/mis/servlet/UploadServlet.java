package com.mis.servlet;

import com.mis.model.Goods;
import com.mis.util.DaoFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(name = "UploadServlet", urlPatterns = {"/Admin/UploadServlet"})
//@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            request.setCharacterEncoding("UTF-8");
            int good_id = Integer.parseInt(request.getParameter("good_id"));
            String good_name = request.getParameter("good_name");
            String price = request.getParameter("price");
            String cnt2 = request.getParameter("count");
            int count =Integer.parseInt(request.getParameter("count"));
            String des =  request.getParameter("des");
            
            //获取文件描述信息
            //String desc = request.getParameter("desc");
            //获取上传的文件
            Part part = request.getPart("pic");
            //获取请求的信息
            String name = part.getHeader("content-disposition");
            //System.out.println(name);//测试使用
            //System.out.println(desc);//

            //获取上传文件的目录
            String root = request.getServletContext().getRealPath("/upload");
            System.out.println("测试上传文件的路径：" + root);

            //获取文件的后缀
            String str = name.substring(name.lastIndexOf("."), name.length() - 1);
            System.out.println("测试获取文件的后缀：" + str);
            
//            String r = UUID.randomUUID().toString();
            String r = good_name;

            //生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
            String filename = root + "\\" + r + str;
            System.out.println("测试产生新的文件名：" + filename);
            
            String pic = r + str;

            //上传文件到指定目录，不想上传文件就不调用这个
            part.write(filename);
            
                  
            Goods good = DaoFactory.getGoodsDao().getOneByGood_id(good_id);
            
            if(good != null){
                int cnt = count + Integer.parseInt(good.getCount());
                String cnt1 = Integer.toString(cnt);
                Goods good1 = new Goods();
                good1.setGood_id(good.getGood_id());
                good1.setCount(cnt1);
                
                DaoFactory.getGoodsDao().updateCount(good1);
            }else{
                Goods good2 = new Goods();

                good2.setGood_id(good_id);
                good2.setGood_name(good_name);
                good2.setPrice(price);
                good2.setCount(cnt2);
                good2.setDes(des);
                good2.setPic(pic);
                DaoFactory.getGoodsDao().insertGoods(good2);
            }
            PrintWriter out = response.getWriter();
                try {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script type=\"text/javascript\"> alert(\"上传文件成功\"); location.href=\"http://localhost:8090/shop//Admin/GoodsManage\"</script>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("</body>");
                    out.println("</html>");
                } finally {
                    out.close();
                }
        } catch (Exception e) {
            e.printStackTrace();
                        PrintWriter out = response.getWriter();
                try {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script type=\"text/javascript\"> alert(\"上传文件失败\"); location.href=\"http://localhost:8090/shop//Admin/GoodsManage\"</script>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("</body>");
                    out.println("</html>");
                } finally {
                    out.close();
                }
        }
    }
}
