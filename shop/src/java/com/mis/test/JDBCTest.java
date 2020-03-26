/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 王焕
 */
public class JDBCTest {
    public static void main(String [] args) throws SQLException{
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String username="shop";
        String password="oracle";
        
        Connection conn=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, username, password);
            psmt=conn.prepareStatement("select admin_id,name,password from admin ");
           // psmt.setInt(1,5);
           //psmt.setString(2, "计算机科学与技术");
            rs=psmt.executeQuery();
            while(rs.next()){
                System.out.print(rs.getString("admin_id")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("password"));
            }
            
//            //测试插入功能
//            psmt =conn.prepareStatement("insert into major(mid,mname,director) values(mid.nextval,?,?)");
//            psmt.setString(1,"人工智能");
//            psmt.setString(2,"王二");
//            int flag=psmt.executeUpdate();
//            System.out.println(flag);
            
//            //测试修改功能
//            psmt =conn.prepareStatement("update major set mid=10 where mid=21");
//            psmt.executeUpdate();
//            psmt =conn.prepareStatement("update major set director=? where mid=? ");
//            psmt.setInt(1, 21);
            
            
            
//            //测试删除功能
//            psmt =conn.prepareStatement("delete from major where mid=10 ");
//            psmt.executeUpdate();
            
            if(rs!=null){
                rs.close();
            }
            if(psmt!=null){
                psmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch(SQLException ex){
            Logger.getLogger(JDBCTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

