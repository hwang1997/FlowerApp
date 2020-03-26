package com.mis.servlet;

import com.mis.model.Goods;
import com.mis.util.DaoFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GoodsUpdateDo", urlPatterns = {"/Admin/GoodsUpdateDo"})
public class GoodsUpdateDo extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            int good_id = Integer.parseInt(request.getParameter("good_id"));
            String good_name = request.getParameter("good_name");
            String price =  request.getParameter("price");
            String count =  request.getParameter("count");
            String des =  request.getParameter("des");
 
            Goods good = new Goods();
            
            good.setGood_id(good_id);
            good.setGood_name(good_name);
            good.setPrice(price);
            good.setCount(count);
            good.setDes(des);
            
            DaoFactory.getGoodsDao().updateGoods(good);
            response.sendRedirect(request.getContextPath() + "/Admin/GoodsManage");         
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
