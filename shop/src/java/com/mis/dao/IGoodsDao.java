/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.dao;

import com.mis.model.Goods;
import com.mis.util.Pagination;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface IGoodsDao {
    public List<Goods> getAll();
    public List<Goods> getGoodsAll(Pagination pagination);
    public List<Goods> getSomeByGood_Id(int good_id,Pagination pagination);
    public List<Goods> getSomeByGood_Name(String good_name,Pagination pagination);
    public void deleteGoods(int good_id);
    public void insertGoods(Goods good);
    public Goods getOneByGood_id(int good_id);
    public void updateCount(Goods good);
     public void updateGoods(Goods good);
     
}
