package com.mis.dao;

import com.mis.model.Admin;


/**
 *
 * @author Administrator
 */
public interface IAdminDao {
     public Admin selectAdmin(String admin_id, String password);
    
}
