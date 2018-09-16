package com.mysheng.office.service.impl;

import com.mysheng.office.enums.ResultEnum;
import com.mysheng.office.exception.CommentException;
import com.mysheng.office.mapper.UserMapper;
import com.mysheng.office.model.User;
import com.mysheng.office.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> queryUsers() {
        return userMapper.queryUsers();
    }

    @Override
    public User queryUserById(int userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(int userId) {
        return userMapper.deleteUser(userId);
    }



    @Override
    public int updateUserPassword(String oldPassword,String userPassword, int userId) {
        String oldPw=userMapper.selectOldPassword(userId);
        if(!oldPassword.equals(oldPw)){
            throw new CommentException(ResultEnum.Pw_ERROR);
        }
        int num=userMapper.updateUserPassword(userPassword,userId);

        return num;
    }

    @Override
    public int loginInfo(String phone, String password) {
        String pw=userMapper.selectPassword(phone);
        if (password.equals(pw)){
            return 1;
        }
        return 0;
    }


}
