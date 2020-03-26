/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.dao;

import com.mis.model.Order;
import com.mis.util.Pagination;
import java.util.List;

/**
 *
 * @author wanghuan
 */
public interface IOrderDao {
    public List<Order> getAll();
    public List<Order> getOrderAll(Pagination pagination) ;
    public List<Order> getSomeByOrder_Id(int order_id,Pagination pagination) ;
    public Order getOneByOrder_id(int order_id);
    public void updateOrder(Order order);
}
