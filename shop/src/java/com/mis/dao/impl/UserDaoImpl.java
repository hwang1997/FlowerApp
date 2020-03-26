package com.mis.dao.impl;

import com.mis.dao.IUserDao;
import com.mis.model.Goods;
import com.mis.model.User;
import com.mis.util.DatabaseBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDaoImpl implements IUserDao{
     Connection conn = null;
     PreparedStatement psmt = null;
     ResultSet rs = null;
     
     @Override
     public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from users order by user_id asc");
            rs = psmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
               
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return users;
    }
     public List<User> getSomeByUser_id(int user_id) {
        List<User> users = new ArrayList<User>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from users where user_id like ?");
            psmt.setString(1, "%" + user_id + "%");
            rs = psmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
           
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return users;
    }
   
      public User getOneByUser_Id(int user_id) {
        User user = null;
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from users where user_id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, user_id);
            rs = psmt.executeQuery();
            if (rs.next()) {
                user = new User();
                
                user.setName(rs.getString("name"));
                user.setUser_id(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return user;
    }
     public void deleteUser(int user_id) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("delete from users where user_id=?");
            psmt.setInt(1, user_id);
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }
      public void insertUser(User user) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("insert into users values(?,?,?)");
            psmt.setString(1, user.getName());
            psmt.setInt(2, user.getUser_id());
            psmt.setString(3, user.getPassword());
            psmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(GoodsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }
      public void updateUser(User user) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("update users set name=?,user_id=?,password=?"
                    + " where user_id=? ");
           
            psmt.setString(1, user.getName());
            psmt.setInt(2, user.getUser_id());
            psmt.setString(3, user.getPassword());
            psmt.setInt(4, user.getUser_id());
            psmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }
     
}
