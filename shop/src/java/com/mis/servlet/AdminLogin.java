
package com.mis.servlet;

import com.mis.model.Admin;
import com.mis.util.DaoFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "AdminLogin", urlPatterns = {"/AdminLogin"})
public class AdminLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
     
        String admin_id = request.getParameter("admin_id");
        String password = request.getParameter("password");
        Admin admin = DaoFactory.getAdminDao().selectAdmin(admin_id, password);
        
        HttpSession session = request.getSession(true);
            if (admin != null) {
                session.setAttribute("admin", admin);
                response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
            } else {
                session.setAttribute("message", "用户名或密码错误，请重新输入！");
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
     
        String admin_id = request.getParameter("admin_id");
        String password = request.getParameter("password");
        Admin admin = DaoFactory.getAdminDao().selectAdmin(admin_id, password);
        HttpSession session = request.getSession(true);
            if (admin != null) {
                session.setAttribute("admin", admin);
                response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
            } else {
                session.setAttribute("message", "用户名或密码错误，请重新输入！");
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            }
        }
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
