package com.mysheng.office.service;

import com.mysheng.office.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 查询全部用户
     * @return
     */
    List<User> queryUsers();

    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    User queryUserById(int userId);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据用户id修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    int deleteUser(int userId);
    /**
     * 根据useId查询旧密码
     * @param userId
     * @return
     */

    int updateUserPassword(String oldPassword,String userPassword,int userId);

    /**
     * 登陆接口
     * @param phone
     * @param password
     * @return
     */
    int loginInfo(String phone,String password);

    List<User> queryList(User temp);

}
