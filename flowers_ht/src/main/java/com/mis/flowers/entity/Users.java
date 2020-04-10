package com.mis.flowers.entity;

import java.io.Serializable;

/**
 * 用户表(Users)实体类
 *
 * @author wanghuan
 * @since 2020-04-02 17:34:49
 */
public class Users implements Serializable {
    private static final long serialVersionUID = 690374474714853279L;
    /**
     * 用户编号
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 用户角色（0：管理员，1：用户）
     */
    private Integer role;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

}