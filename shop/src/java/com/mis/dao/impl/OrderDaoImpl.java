package com.mis.dao.impl;

import com.mis.dao.IOrderDao;
import com.mis.model.Goods;
import com.mis.model.Order;
import com.mis.model.User;
import com.mis.util.DatabaseBean;
import com.mis.util.Pagination;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDaoImpl implements IOrderDao {

    Connection conn = null;
    PreparedStatement psmt = null;
    ResultSet rs = null;

    public List<Order> getAll() {
        List<Order> orders = new ArrayList<Order>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from orders natural join goods natural join users order by order_id asc");
            rs = psmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                Goods good = new Goods();
                User user = new User();

                order.setOrder_id(rs.getInt("order_id"));
                order.setOrder_name(rs.getString("order_name"));
                order.setPhone(rs.getString("phone"));
                order.setAddress(rs.getString("address"));
                order.setPay(rs.getString("Pay"));
                order.setState(rs.getString("state"));

                good.setGood_id(rs.getInt("good_id"));
                good.setGood_name(rs.getString("good_name"));
                good.setPrice(rs.getString("price"));
                
                user.setName(rs.getString("name"));
                user.setUser_id(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                
                order.setUser(user);

                order.setGood(good);
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return orders;
    }

    public List<Order> getOrderAll(Pagination pagination) {
        List<Order> orders = new ArrayList<>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from orders");
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("select * from (select rownum no,order_id,name,user_id,password,good_id,good_name,price,amount,sumPrice,order_name,phone,"
                    + "address,pay,state from orders natural join goods natural join users where rownum<=? order by order_id asc) where no>=?");
            psmt.setInt(1, end);
            psmt.setInt(2, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
               Order order = new Order();
                Goods good = new Goods();
                User user = new User();

                order.setOrder_id(rs.getInt("order_id"));
                order.setOrder_name(rs.getString("order_name"));
                order.setAmount(rs.getString("amount"));
                order.setPhone(rs.getString("phone"));
                order.setAddress(rs.getString("address"));
                order.setPay(rs.getString("Pay"));
                order.setState(rs.getString("state"));

                good.setGood_id(rs.getInt("good_id"));
                good.setGood_name(rs.getString("good_name"));
                good.setPrice(rs.getString("price"));
                
                user.setName(rs.getString("name"));
                user.setUser_id(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                
                order.setUser(user);

                order.setGood(good);
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return orders;
    }
    
     public List<Order> getSomeByOrder_Id(int order_id,Pagination pagination) {
        List<Order> orders = new ArrayList<Order>();
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select count(*) as counts from orders where order_id like ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + order_id + "%");
            rs = psmt.executeQuery();
            rs.next();
            pagination.setCountSize(rs.getInt("counts"));
            //求指定显示的记录数
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;
            int perPage = pagination.getPageSize();
            int end = pagination.getPageNo() * perPage;
            sql = "select * from (select rownum no,order_id,name,user_id,password,good_id,good_name,price,amount,sumPrice,order_name,phone,address,pay,state"
                    + " from orders natural join goods natural join users where order_id like ? and rownum<=? order by order_id asc)where no>=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + order_id + "%");
            psmt.setInt(2, end);
            psmt.setInt(3, start);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Order order = new Order();
                Goods good = new Goods();
                User user = new User();

                order.setOrder_id(rs.getInt("order_id"));
                order.setOrder_name(rs.getString("order_name"));
                order.setAmount(rs.getString("amount"));
                order.setPhone(rs.getString("phone"));
                order.setAddress(rs.getString("address"));
                order.setPay(rs.getString("Pay"));
                order.setState(rs.getString("state"));

                good.setGood_id(rs.getInt("good_id"));
                good.setGood_name(rs.getString("good_name"));
                good.setPrice(rs.getString("price"));
                
                user.setName(rs.getString("name"));
                user.setUser_id(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                
                order.setUser(user);

                order.setGood(good);
                orders.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return orders;
    }

     public Order getOneByOrder_id(int order_id) {
         Order order = null;
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from orders natural join goods natural join users where order_id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, order_id);
            rs = psmt.executeQuery();
            if (rs.next()) {
                Goods good = new Goods();
                order = new Order();
                User user = new User();

                order.setOrder_id(rs.getInt("order_id"));
                order.setOrder_name(rs.getString("order_name"));
                order.setAmount(rs.getString("amount"));
                order.setPhone(rs.getString("phone"));
                order.setAddress(rs.getString("address"));
                order.setPay(rs.getString("Pay"));
                order.setState(rs.getString("state"));

                good.setGood_id(rs.getInt("good_id"));
                good.setGood_name(rs.getString("good_name"));
                good.setPrice(rs.getString("price"));
                
                user.setName(rs.getString("name"));
                user.setUser_id(rs.getInt("user_id"));
                user.setPassword(rs.getString("password"));
                
                order.setUser(user);

                order.setGood(good);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return order;
    }
      public void updateOrder(Order order) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("update orders set order_name=?,phone=?,address=?,state=?"
                    + " where order_id=? ");
            psmt.setString(1, order.getOrder_name());
            psmt.setString(2, order.getPhone());
            psmt.setString(3, order.getAddress());
            psmt.setString(4, order.getState());
            psmt.setInt(5, order.getOrder_id());
            psmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(OrderDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }

}
