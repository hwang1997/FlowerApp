package com.mis.servlet;

import com.mis.model.Order;
import com.mis.util.DaoFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OrderUpdateDo", urlPatterns = {"/Admin/OrderUpdateDo"})
public class OrderUpdateDo extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            int order_id = Integer.parseInt(request.getParameter("order_id"));
            String order_name =  request.getParameter("order_name");
            String phone =  request.getParameter("phone");
            String address =  request.getParameter("address");
            String state =  request.getParameter("state");
            
            if("0".equals(state)){
                PrintWriter out = response.getWriter();
                try {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script type=\"text/javascript\"> alert(\"订单状态不能为“请选择订单状态”，请重新选择！\"); location.href=\"http://localhost:8090/shop/Admin/OrderManage\"</script>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("</body>");
                    out.println("</html>");
                } finally {
                    out.close();
                }
            }else{
                Order order = new Order();
            
                order.setOrder_id(order_id);
                order.setOrder_name(order_name);
                order.setPhone(phone);
                order.setAddress(address);
                order.setState(state);

                DaoFactory.getOrderDao().updateOrder(order);
                response.sendRedirect(request.getContextPath() + "/Admin/OrderManage");   
            }
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
