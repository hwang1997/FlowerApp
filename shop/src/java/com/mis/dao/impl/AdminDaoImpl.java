/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.dao.impl;

import com.mis.util.DatabaseBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mis.dao.IAdminDao;
import com.mis.model.Admin;

/**
 *
 * @author Administrator
 */
public class AdminDaoImpl implements IAdminDao{
    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    public Admin selectAdmin(String admin_id, String password) {
        Admin admin = null;
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from admin where admin_id=? and password=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, admin_id);
            psmt.setString(2, password);
            rs = psmt.executeQuery();
            if (rs.next()) {
                admin = new Admin();
                admin.setAdmin_id(rs.getString("admin_id"));
                admin.setName(rs.getString("name"));
                admin.setPassword(rs.getString("password"));
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return admin;
    }
}
