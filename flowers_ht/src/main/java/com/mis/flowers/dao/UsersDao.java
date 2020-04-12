package com.mis.flowers.dao;

import com.mis.flowers.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表(Users)表数据库访问层
 *
 * @author wanghuan
 * @since 2020-04-02 17:34:49
 */
@Mapper
public interface UsersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    Users queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Users> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


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
     * 新增数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 影响行数
     */
    int update(Users users);
    /**
     * 修改数据
     *
     * @param userId 实例对象
     * @return 影响行数
     */
    boolean updatePwd(Integer userId, String pwd);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);


}