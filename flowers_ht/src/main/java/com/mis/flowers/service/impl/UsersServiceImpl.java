package com.mis.flowers.service.impl;

import com.mis.flowers.entity.Users;
import com.mis.flowers.dao.UsersDao;
import com.mis.flowers.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(Users)表服务实现类
 *
 * @author wanghuan
 * @since 2020-04-02 17:34:50
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(Integer userId) {
        return this.usersDao.queryById(userId);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param loginId 主键
     * @return 实例对象
     */
    @Override
    public Users queryByloginId(String loginId) {
        return this.usersDao.queryByloginId(loginId);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param userName 主键
     * @return 实例对象
     */
    @Override
    public List<Users> queryByUsername(String userName) {
        return this.usersDao.queryByUsername(userName);
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @return 对象列表
     */
    @Override
    public List<Users> selectAll() {
        return this.usersDao.selectAll();
    }
    /**
     * 通过实体作为筛选条件查询
     *
     * @param users 实例对象
     * @return 对象列表
     */
    @Override
    public List<Users> queryAll(Users users) {
        return this.usersDao.queryAll(users);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Users> queryAllByLimit(int offset, int limit) {
        return this.usersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users insert(Users users) {
        this.usersDao.insert(users);
        return users;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users update(Users users) {
        this.usersDao.update(users);
        return this.queryById(users.getUserId());
    }
    /**
     * 修改登录账号
     *
     * @param loginId 实例对象
     * @return 是否成功
     */
    @Override
    public boolean changeLoginId(Integer userId, String loginId) {
        return this.usersDao.changeLoginId(userId,loginId);
    }
    /**
     * 修改数据
     *
     * @param userId 实例对象
     * @return 是否成功
     */
    @Override
    public boolean changeUsername(Integer userId, String newUsername) {
       return this.usersDao.changeUsername(userId,newUsername);
    }
    /**
     * 修改用户密码
     *
     * @param userId 实例对象
     * @return 是否成功
     */
    @Override
    public boolean updatePwd(Integer userId, String pwd) {
        return this.usersDao.updatePwd(userId,pwd);
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userId) {
        return this.usersDao.deleteById(userId) > 0;
    }
}