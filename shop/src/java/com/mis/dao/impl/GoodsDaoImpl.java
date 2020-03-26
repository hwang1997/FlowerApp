package com.mis.dao.impl;

import com.mis.dao.IGoodsDao;
import com.mis.model.Goods;
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


public class GoodsDaoImpl implements IGoodsDao{
     Connection conn = null;
     PreparedStatement psmt = null;
     ResultSet rs = null;
     @Override
     public List<Goods> getAll() {
        List<Goods> goods = new ArrayList<Goods>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select * from goods order by good_id asc");
            rs = psmt.executeQuery();
            while (rs.next()) {
                Goods good = new Goods();
              
                good.setGood_id(rs.getInt("good_id"));
                good.setGood_name(rs.getString("good_name"));
                good.setPrice(rs.getString("price"));
                good.setCount(rs.getString("count"));
                good.setDes(rs.getString("des"));
                good.setPic(rs.getString("pic"));
                goods.add(good);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoodsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return goods;
    }
      public List<Goods> getGoodsAll(Pagination pagination) {
        List<Goods> goods = new ArrayList<Goods>();
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("select count(*) as counts from goods");
            rs = psmt.executeQuery();
            rs.next();
            //求总记录数
            pagination.setCountSize(rs.getInt("counts"));
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;//开始位置
            int end = pagination.getPageNo() * pagination.getPageSize();//结束位置
            psmt = conn.prepareStatement("select * from (select rownum no,good_id,good_name,price,count,des,pic from goods where rownum<=? order by good_id asc) where no>=?");      
            psmt.setInt(1, end);
            psmt.setInt(2, start);
            rs = psmt.executeQuery();
            while (rs.next()) {
                Goods good = new Goods();
                
                good.setGood_id(rs.getInt("good_id"));
                good.setGood_name(rs.getString("good_name"));
                good.setPrice(rs.getString("price"));
                good.setCount(rs.getString("count"));
                good.setDes(rs.getString("des"));
                good.setPic(rs.getString("pic"));
                goods.add(good);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoodsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return goods;
    }
     
     public List<Goods> getSomeByGood_Id(int good_id,Pagination pagination) {
        List<Goods> goods = new ArrayList<>();
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select count(*) as counts from goods where good_id like ?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, good_id );
            rs = psmt.executeQuery();
            rs.next();
            pagination.setCountSize(rs.getInt("counts"));
            //求指定显示的记录数
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;
            int perPage = pagination.getPageSize();
            int end = pagination.getPageNo() * perPage;
            sql = "select * from (select rownum no,good_id,good_name,price,count,des,pic from goods where good_id like ? and rownum<=? order by good_id asc)where no>=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, good_id );
            psmt.setInt(2, end);
            psmt.setInt(3, start);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Goods good = new Goods();
               
                good.setGood_id(rs.getInt("good_id"));
                good.setGood_name(rs.getString("good_name"));
                good.setPrice(rs.getString("price"));
                good.setCount(rs.getString("count"));
                good.setDes(rs.getString("des"));
                good.setPic(rs.getString("pic"));
                goods.add(good);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoodsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return goods;
    }
      public List<Goods> getSomeByGood_Name(String good_name,Pagination pagination) {
        List<Goods> goods = new ArrayList<>();
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select count(*) as counts from goods where good_name like ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + good_name + "%");
            rs = psmt.executeQuery();
            rs.next();
            pagination.setCountSize(rs.getInt("counts"));
            //求指定显示的记录数
            int start = (pagination.getPageNo() - 1) * pagination.getPageSize() + 1;
            int perPage = pagination.getPageSize();
            int end = pagination.getPageNo() * perPage;
            sql = "select * from (select rownum no,good_id,good_name,price,count,des,pic from goods where good_name like ? and rownum<=? order by good_id asc)where no>=?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, "%" + good_name + "%");
            psmt.setInt(2, end);
            psmt.setInt(3, start);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Goods good = new Goods();
                good.setGood_id(rs.getInt("good_id"));
                good.setGood_name(rs.getString("good_name"));
                good.setPrice(rs.getString("price"));
                good.setCount(rs.getString("count"));
                good.setDes(rs.getString("des"));
                good.setPic(rs.getString("pic"));
                goods.add(good);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoodsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return goods;
    }
     
     public void deleteGoods(int good_id) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("delete from goods where good_id=?");
            psmt.setInt(1, good_id);
            psmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GoodsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }
     public void insertGoods(Goods good) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("insert into goods values(?,?,?,?,?,?)");
            psmt.setInt(1, good.getGood_id());
            psmt.setString(2, good.getGood_name());
            psmt.setString(3, good.getPrice());
            psmt.setString(4, good.getCount());
            psmt.setString(5, good.getDes());
            psmt.setString(6, good.getPic());
            psmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(GoodsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }
     public Goods getOneByGood_id(int good_id) {
        Goods good = null;
        try {
            conn = DatabaseBean.getConnection();
            String sql = "select * from goods where good_id=?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, good_id);
            rs = psmt.executeQuery();
            if (rs.next()) {
                good = new Goods();
                good.setGood_id(rs.getInt("good_id"));
                good.setGood_name(rs.getString("good_name"));
                good.setPrice(rs.getString("price"));
                good.setCount(rs.getString("count"));
                good.setDes(rs.getString("des"));
                good.setPic(rs.getString("pic"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GoodsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
        return good;
    }
     public void updateCount(Goods good) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("update goods set count=? where good_id=? ");
            psmt.setString(1, good.getCount());
            psmt.setInt(2, good.getGood_id());
            psmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }
      public void updateGoods(Goods good) {
        try {
            conn = DatabaseBean.getConnection();
            psmt = conn.prepareStatement("update goods set good_id=?,good_name=?,price=?,count=?,des=?,pic=?"
                    + " where good_id=? ");
            psmt.setInt(1, good.getGood_id());
            psmt.setString(2, good.getGood_name());
            psmt.setString(3, good.getPrice());
            psmt.setString(4, good.getCount());
            psmt.setString(5, good.getDes());
            psmt.setString(6, good.getPic());
            psmt.setInt(7, good.getGood_id());
            psmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(GoodsDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DatabaseBean.close(rs, psmt, conn);
        }
    }
}
