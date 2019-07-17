package com.mysheng.office.mapper;
import com.mysheng.office.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserModelMapper {
    /**
     * 查询全部用户
     * @return
     */
    List<UserModel> queryUsers();
    /**
     * 根据用户手机号查询用户
     * @param phone
     * @return
     */
    UserModel queryUserByPhone(String phone);

    /**
     * 根据用户手机号查询用户
     * @param id
     * @return
     */
    UserModel queryUserById(String id);

    /**
     * 更具用户id查询手机号
     * @param id
     * @return
     */
    String queryUserPhoneById(String id);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int insertUser(UserModel user);

    /**
     * 根据用户id修改用户信息
     * @param user
     * @return
     */
    int updateUser(UserModel user);
    /**
     * 根据用户id修改用户信息
     * @param phone
     * @return
     */
    int updateUserPassword(@Param("userPassword") String userPassword, @Param("phoneNum") String phone);
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
    String selectOldPassword(String phone);
    /**
     * 根据手机号登陆
     */
    String selectPassword(String phone);

    List<UserModel> queryList(UserModel temp);
}
