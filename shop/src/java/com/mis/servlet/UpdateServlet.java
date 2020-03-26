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


@WebServlet(name = "UpdateServlet", urlPatterns = {"/Admin/UpdateServlet"})
//@WebServlet("/upload")
@MultipartConfig
public class UpdateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            int good_id = Integer.parseInt(request.getParameter("good_id"));
            String good_name = request.getParameter("good_name");
            String price = request.getParameter("price");
            String count = request.getParameter("count");
            String des =  request.getParameter("des");
        try {
            //获取文件描述信息
            //String desc = request.getParameter("desc");
            //获取上传的文件
            Part part = request.getPart("pic");
            System.out.print(part.getSubmittedFileName());
            //如果上传图片为空，则不进行修改，图片为原图片
            if(part.getSubmittedFileName() == ""){
            Goods good1 = DaoFactory.getGoodsDao().getOneByGood_id(good_id);
            String pic = good1.getPic();
            Goods good = new Goods();
            
            good.setGood_id(good_id);
            good.setGood_name(good_name);
            good.setPrice(price);
            good.setCount(count);
            good.setDes(des);
            good.setPic(pic);
            DaoFactory.getGoodsDao().updateGoods(good);
            response.sendRedirect(request.getContextPath() + "/Admin/GoodsManage"); 
            return;
            }
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
            
            String r = UUID.randomUUID().toString();

            //生成一个新的文件名，不重复，数据库存储的就是这个文件名，不重复的
            String filename = root + "\\" + r + str;
            System.out.println("测试产生新的文件名：" + filename);
            
            String pic = r + str;

            //上传文件到指定目录，不想上传文件就不调用这个
            part.write(filename);

            Goods good = new Goods();
            
            good.setGood_id(good_id);
            good.setGood_name(good_name);
            good.setPrice(price);
            good.setCount(count);
            good.setDes(des);
            good.setPic(pic);
            
            DaoFactory.getGoodsDao().updateGoods(good);
            PrintWriter out = response.getWriter();
            try {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<script type=\"text/javascript\"> alert(\"修改成功\"); location.href=\"http://localhost:8090/shop//Admin/GoodsManage\"</script>");
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
