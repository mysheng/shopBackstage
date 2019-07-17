package com.mysheng.office.service;

import com.mysheng.office.model.LoginMode;
import com.mysheng.office.model.TokenModel;
import com.mysheng.office.model.UserModel;

import java.util.List;

public interface UserModelService {
    /**
     * 查询全部用户
     * @return
     */
    List<UserModel> queryUsers();

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    UserModel queryUserById(String id);
    /**
     * 根据用户id查询用户
     * @param phone
     * @return
     */
    UserModel queryUserByPhone(String phone);

    /**
     * 新增用户
     * @param user
     * @return
     */
    TokenModel insertUser(UserModel user);

    /**
     * 根据用户id修改用户信息
     * @param user
     * @return
     */
    TokenModel updateUser(UserModel user);

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    int deleteUser(String userId);
    /**
     * 根据useId查询旧密码
     * @param phone
     * @return
     */

    int updateUserPassword(String oldPassword, String userPassword, String phone);

    /**
     * 登陆接口
     * @param phone
     * @param password
     * @return
     */
    TokenModel loginInfo(String phone, String password);

    List<UserModel> queryList(UserModel temp);
}
