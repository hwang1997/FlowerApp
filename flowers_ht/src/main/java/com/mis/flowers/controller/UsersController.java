package com.mis.flowers.controller;

import com.mis.flowers.dto.*;
import com.mis.flowers.entity.Users;
import com.mis.flowers.service.UsersService;
import com.mis.flowers.util.MD5Util;
import com.mis.flowers.util.Page;
import com.mis.flowers.util.Result;
import com.mis.flowers.util.ResultCode;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户表(Users)表控制层
 *
 * @author wanghuan
 * @since 2020-04-02 17:34:51
 */
@RestController
@RequestMapping("users")
public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    /**
     * 通过主键查询单条数据
     *
     * @param dto 主键
     * @return 单条数据
     */
    //web登录
    @SneakyThrows
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result<Users> login(UserDto dto) {
        try {
            String password = MD5Util.md5Encode(dto.getUser_password());
            Users user = this.usersService.queryByloginId(dto.getLogin_id());
            if (user == null) {
                return Result.createFailUre(ResultCode.Fail.code(), "用户不存在！");
            } else if (user.getRole() == 1) {
                return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "无权限");
            } else if (!user.getUserPassword().equals(password)) {
                return Result.createFailUre(ResultCode.Fail.code(), "密码错误！");
            } else {
                return Result.createSuccess(user);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }
    //App登录
    @SneakyThrows
    @RequestMapping(value = "applogin", method = RequestMethod.POST)
    public Result<Users> applogin(UserDto dto) {
        try {
            String password = MD5Util.md5Encode(dto.getUser_password());
            Users user = this.usersService.queryByloginId(dto.getLogin_id());
            if (user == null) {
                return Result.createFailUre(ResultCode.Fail.code(), "用户不存在！");
            } else if (user.getRole() == 0) {
                return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "无权限");
            } else if (!user.getUserPassword().equals(password)) {
                return Result.createFailUre(ResultCode.Fail.code(), "密码错误！");
            } else {
                return Result.createSuccess(user);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }
    //锁屏验证
    @SneakyThrows
    @RequestMapping(value = "checkPwd", method = RequestMethod.POST)
    public Boolean checkPwd(UserDto dto) {
        try {
            String password = MD5Util.md5Encode(dto.getUser_password());
            Users user = this.usersService.queryById(dto.getUser_id());
            if (user == null){
                return false;
            }else if (!user.getUserPassword().equals(password)) {
                return false;
            } else {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 通过userId查询单条数据
     *
     * @param loginId 主键
     * @return 单条数据
     */
    @RequestMapping(value = "userDoSearch", method = RequestMethod.GET)
    public Result<List<Users>> userDoSearch(String loginId) {
        try {
            Users users1 = this.usersService.queryByloginId(loginId);
            if (users1 == null){
                return Result.createFailUre(ResultCode.ERROR_PARAM.code(),"该用户不存在！");
            }else {
                List<Users> users = new ArrayList<>();
                users.add(this.usersService.queryByloginId(loginId));
                return Result.createSuccess(users);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }
    /**
     * 通过userName查询单条数据
     *
     * @param userName 主键
     * @return 单条数据
     */
    @RequestMapping(value = "userDoSearchByUsername", method = RequestMethod.GET)
    public Result<List<Users>> userDoSearchByUsername(String userName) {
        try {
            List<Users> users1 = this.usersService.queryByUsername(userName);
            if (users1 == null){
                return Result.createFailUre(ResultCode.ERROR_PARAM.code(),"该用户不存在！");
            }else {
                List<Users> users = this.usersService.queryByUsername(userName);
                return Result.createSuccess(users);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }

    //插入
    @SneakyThrows
    @RequestMapping(value = "insertUsers", method = RequestMethod.POST)
    public Result<Integer> insertUsers(addUserDto dto) {
        try {
            Users users1 = new Users();
            users1 = this.usersService.queryByloginId(dto.getLoginId());
            if (users1 != null){
                return Result.createFailUre(ResultCode.ERROR_PARAM.code(),"该账号已存在,无法添加！");
            }else {
                Users users = new Users();
                users.setLoginId(dto.getLoginId());
                users.setUserName(dto.getUserName());
                String password = MD5Util.md5Encode(dto.getUserPassword());
                users.setUserPassword(password);
                users.setRole(dto.getRole());
                this.usersService.insert(users);
                return Result.createSuccess();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }

    //删除
    @RequestMapping(value = "deleteUsers", method = RequestMethod.DELETE)
    public Result<Boolean> deleteUsers(Integer userId) {
        try {
            this.usersService.deleteById(userId);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }

    //批量删除
    @RequestMapping(value = "batchDelete", method = RequestMethod.DELETE)
    public Result<Boolean> batchDelete(int[] userId) {
       try {
           if (userId != null){
               for (int i = 0; i < userId.length; i++) {
                   this.usersService.deleteById(userId[i]);
               }
               for (int j = 0; j < userId.length; j++) {
                   if (this.usersService.queryById(userId[j]) != null) {
                       return Result.createFailUre(ResultCode.Fail.code(), "删除失败！");
                   }
               }
               return Result.createSuccess();
           }else {
               return Result.createFailUre(ResultCode.Fail.code(),"失败！");
           }
       }catch (Exception e){
           e.printStackTrace();
           return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
       }
    }

    //修改用户信息
    @SneakyThrows//MD5
    @RequestMapping(value = "updateUsers", method = RequestMethod.POST)
    public Result<Users> updateUsers(updateUserDto dto) {
        try {
            Users users1 = this.usersService.queryByloginId(dto.getLoginId());
            Users users2 = this.usersService.queryById(dto.getUserId());

            if (users1 == null){
                String password = "";
                if (users2.getUserPassword().equals(dto.getUserPassword())){
                    password = dto.getUserPassword();
                }else {
                    password = MD5Util.md5Encode(dto.getUserPassword());
                }
                Users users = new Users();
                users.setUserId(dto.getUserId());
                users.setLoginId(dto.getLoginId());
                users.setUserName(dto.getUserName());
                users.setUserPassword(password);
                users.setRole(dto.getRole());
                this.usersService.update(users);
                return Result.createSuccess();
            }else {
                if (users1.getUserId().equals(users2.getUserId())){
                    Users users = new Users();
                    users.setUserId(dto.getUserId());
                    users.setLoginId(dto.getLoginId());
                    users.setUserName(dto.getUserName());
                    String password = "";
                    if (users2.getUserPassword().equals(dto.getUserPassword())){
                        password = dto.getUserPassword();
                    }else {
                        password = MD5Util.md5Encode(dto.getUserPassword());
                    }
                    users.setUserPassword(password);
                    users.setRole(dto.getRole());
                    this.usersService.update(users);
                    return Result.createSuccess();
                }
                return Result.createFailUre(ResultCode.ERROR_PARAM.code(),"该账号已存在，无法修改");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }
    //APP修改登陆账号
    @RequestMapping(value = "changeLoginId", method = RequestMethod.POST)
    public Result<Users> changeLoginId(String userId, String loginId) {
        try {
            Users users1 = this.usersService.queryById(Integer.parseInt(userId));
            if (users1 != null){
                return Result.createFailUre(ResultCode.ERROR_PARAM.code(),"该账号已存在！");
            }else {
                this.usersService.changeLoginId(Integer.parseInt(userId),loginId);
                Users users = this.usersService.queryById(Integer.parseInt(userId));
                return Result.createSuccess(users);
            }
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }
    //APP修改用户名
    @RequestMapping(value = "changeUsername", method = RequestMethod.POST)
    public Result<Users> changeUsername(String userId, String user_name) {
        try {
            this.usersService.changeUsername(Integer.parseInt(userId),user_name);
            Users users = this.usersService.queryById(Integer.parseInt(userId));
            return Result.createSuccess(users);
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }
    //修改用户密码
    @SneakyThrows//MD5
    @RequestMapping(value = "updatePwd", method = RequestMethod.GET)
    public Result<Boolean> updatePwd(Integer userId, String pwd) {
        try {
            String password = MD5Util.md5Encode(pwd);
            this.usersService.updatePwd(userId,password);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }
    //APP修改用户密码
    @SneakyThrows//MD5
    @RequestMapping(value = "changePwd", method = RequestMethod.POST)
    public Result<Boolean> changePwd(String userId, String pwd) {
        try {
            String password = MD5Util.md5Encode(pwd);
            this.usersService.updatePwd(Integer.parseInt(userId),password);
            return Result.createSuccess();
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }
    }

    //分页
    @RequestMapping(value = "selectByPage", method = RequestMethod.GET)
    public Result<Page<Users>> selectByPage(int page, int limit) {
        try {
            List<Users> list = this.usersService.queryAllByLimit((page-1)*limit,limit);
            Integer count = this.usersService.selectAll().size();
            Page<Users> usersPage = new Page<Users>(list,count);
            return Result.createSuccess(usersPage);
        }catch (Exception e){
            e.printStackTrace();
            return Result.createFailUre(ResultCode.INTERNAL_SERVER_ERROR.code(), "服务器异常");
        }

    }
}