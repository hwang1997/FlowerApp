/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.util;

import com.mis.dao.impl.GoodsDaoImpl;
import com.mis.dao.impl.AdminDaoImpl;
import com.mis.dao.IAdminDao;
import com.mis.dao.IUserDao;
import com.mis.dao.impl.UserDaoImpl;
import com.mis.dao.IGoodsDao;
import com.mis.dao.IOrderDao;
import com.mis.dao.impl.OrderDaoImpl;

/**
 *
 * @author Administrator
 */
public class DaoFactory {
     public static IAdminDao getAdminDao() {
        return new AdminDaoImpl();
    }
    public static IGoodsDao getSupDao() {
        return new GoodsDaoImpl();
    }
     public static IOrderDao getOrderDao() {
        return new OrderDaoImpl();
    }
       public static IUserDao getUserDao(){
        return new UserDaoImpl();
    }
    public static IGoodsDao getGoodsDao(){
        return new GoodsDaoImpl();
    }
}
