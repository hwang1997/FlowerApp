package com.mis.flowers.service;

import com.mis.flowers.entity.Users;

import java.util.List;

/**
 * 用户表(Users)表服务接口
 *
 * @author wanghuans
 * @since 2020-04-02 17:34:50
 */
public interface UsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    Users queryById(Integer userId);
    /**
     * 通过ID查询单条数据
     *
     * @param loginId 主键
     * @return 实例对象
     */
    Users queryByloginId(String loginId);
    /**
     * 通过userName查询单条数据
     *
     * @param userName 主键
     * @return 实例对象
     */
    List<Users> queryByUsername(String userName);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param users 实例对象
     * @return 对象列表
     */
    List<Users> queryAll(Users users);

    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    List<Users> selectAll();
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Users> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    Users update(Users users);

    /**
     * 修改数据
     *
     * @param userId 实例对象
     * @return 实例对象
     */
    boolean updatePwd(Integer userId,String pwd);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

    /**
     * 通过主键修改用户名
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean changeUsername(Integer userId, String newUsername);

    /**
     * 通过主键修改登录账号
     *
     * @param loginId 主键
     * @return 是否成功
     */
    boolean changeLoginId(Integer userId, String loginId);
}