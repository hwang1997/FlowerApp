package com.mis.servlet;


import com.mis.model.Order;
import com.mis.util.DaoFactory;
import com.mis.util.Pagination;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OrderManage", urlPatterns = {"/Admin/OrderManage"})
public class OrderManage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");       
       String order_id = request.getParameter("order_id");
       String pageNo=request.getParameter("pageNo");
        int page=1;
        if(pageNo!=null){
            page=Integer.parseInt(pageNo);
              }
        Pagination pagination=new Pagination();
        pagination.setPageNo(page);
        pagination.setUrl("OrderManage?");
        List<Order> orders = null;
        
       if (order_id != null && !"".equals(order_id)) {
            int order_id1 = Integer.parseInt(order_id);
            orders = DaoFactory.getOrderDao().getSomeByOrder_Id(order_id1, pagination);
        } else {
            orders = DaoFactory.getOrderDao().getOrderAll(pagination);
        }
        request.setAttribute("orders", orders);
        request.setAttribute("pagination",pagination);
        request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
        
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
