/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mis.dao;

import com.mis.model.User;
import java.util.List;

/**
 *
 * @author wanghuan
 */
public interface IUserDao {
    public List<User> getAll();
    public List<User> getSomeByUser_id(int user_id);
    public void deleteUser(int user_id);
    public void insertUser(User user);
    public User getOneByUser_Id(int user_id);
    public void updateUser(User user) ;
}
