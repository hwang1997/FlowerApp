package com.mis.servlet;

import com.mis.model.Goods;
import com.mis.util.DaoFactory;
import com.mis.util.Pagination;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GoodsManage", urlPatterns = {"/Admin/GoodsManage"})
public class GoodsManage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
       String good_id = request.getParameter("good_id");
       String good_name = request.getParameter("good_name");
       String pageNo=request.getParameter("pageNo");
        int page=1;
        if(pageNo!=null){
            page=Integer.parseInt(pageNo);
              }
        Pagination pagination=new Pagination();
        pagination.setPageNo(page);
        pagination.setUrl("GoodsManage?");
        List<Goods> goods = null;
        
        if((good_id != null && !"".equals(good_id)) || (good_name == null && "".equals(good_name))){
            int good_id1 = Integer.parseInt(good_id);
            goods = DaoFactory.getGoodsDao().getSomeByGood_Id(good_id1, pagination);
        }else if((good_id == null && "".equals(good_id)) || (good_name != null && !"".equals(good_name))){
            goods = DaoFactory.getGoodsDao().getSomeByGood_Name(good_name, pagination);
        }else if((good_id != null && !"".equals(good_id)) || (good_name != null && !"".equals(good_name))){
            int good_id1 = Integer.parseInt(good_id);
            goods = DaoFactory.getGoodsDao().getSomeByGood_Id(good_id1, pagination);
        }else{
            goods = DaoFactory.getGoodsDao().getGoodsAll(pagination); 
        }
       
        request.setAttribute("goods", goods);
        request.setAttribute("pagination",pagination);
        request.getRequestDispatcher("/admin/goods.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
