package com.mysheng.office.mapper;
import com.mysheng.office.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
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
     * 根据用户id修改用户信息
     * @param userId
     * @return
     */
    int updateUserPassword(@Param("userPassword") String userPassword,@Param("userId") int userId);
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
    String selectOldPassword(int userId);
    /**
     * 根据手机号登陆
     */
    String selectPassword(String phone);


    List<User> queryList(User temp);

}
