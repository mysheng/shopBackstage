package com.mysheng.office.service.impl;

import com.mysheng.office.enums.ResultError;
import com.mysheng.office.exception.CustomException;
import com.mysheng.office.mapper.TokenMapper;
import com.mysheng.office.mapper.UserModelMapper;
import com.mysheng.office.model.TokenModel;
import com.mysheng.office.model.UserModel;
import com.mysheng.office.service.UserModelService;
import com.mysheng.office.util.MD5Utils;
import com.mysheng.office.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserModelServiceImpl implements UserModelService {
    @Autowired
    private UserModelMapper userMapper;
    @Autowired
    private TokenMapper tokenMapper;
    @Override
    public List<UserModel> queryUsers() {


        List<UserModel> list=userMapper.queryUsers();

        return list;
    }

    @Override
    public UserModel  queryUserById(String userId) {
        return userMapper.queryUserById(userId);
    }
    @Override
    public UserModel queryUserByPhone(String phone) {
        return userMapper.queryUserByPhone(phone);
    }

    @Override
    @Transactional
    public TokenModel insertUser(UserModel user) {
        user.setId(UUIDUtil.getUUID());
        user.setPassword(MD5Utils.md5(user.getPassword()));
        int num1=userMapper.insertUser(user);
        TokenModel tokenModel=new TokenModel();
        tokenModel.setId(UUIDUtil.getUUID());
        tokenModel.setAvatar(user.getAvatar());
        String loginName=user.getLoginName()==null?user.getNickName():user.getLoginName();
        tokenModel.setLoginName(loginName);
        tokenModel.setPhone(user.getPhoneNum());
        tokenModel.setUserId(user.getId());
        tokenModel.setOpenId(user.getOpenId());
        tokenModel.setToken(MD5Utils.md5(user.getPhoneNum()));
        int num2=tokenMapper.insertToken(tokenModel);
        if(num1>0&&num2>0){

            return tokenModel;
        }
        return null;
    }

    @Override
    @Transactional
    public TokenModel updateUser(UserModel user) {
        user.setPassword(MD5Utils.md5(user.getPassword()));
        userMapper.updateUser(user);
        TokenModel tokenModel=new TokenModel();
        tokenModel.setId(UUIDUtil.getUUID());
        tokenModel.setAvatar(user.getAvatar());
        String loginName=user.getLoginName()==null?user.getNickName():user.getLoginName();
        tokenModel.setLoginName(loginName);
        tokenModel.setPhone(user.getPhoneNum());
        tokenModel.setUserId(user.getId());
        tokenModel.setOpenId(user.getOpenId());
        tokenModel.setToken(MD5Utils.md5(user.getPhoneNum()));
        tokenMapper.updateToken(tokenModel);
        return tokenMapper.queryTokenByPhone(user.getPhoneNum());
    }

    @Override
    public int deleteUser(String userId) {
        return userMapper.deleteUser(userId);
    }



    @Override
    public int updateUserPassword(String oldPassword,String userPassword, String phone) {
        String oldPw=userMapper.selectOldPassword(phone);
        if(!oldPassword.equals(oldPw)){
            throw new CustomException(ResultError.Pw_ERROR);
        }
        int num=userMapper.updateUserPassword(userPassword,phone);

        return num;
    }

    @Override
    public TokenModel loginInfo(String phone, String password) {

        UserModel user=userMapper.queryUserByPhone(phone);
        password=MD5Utils.md5(password);
        if (user!=null&&password.equals(user.getPassword())){
            TokenModel tokenModel=tokenMapper.queryTokenById(user.getId());

            return tokenModel;
        }
       return null;

    }
    @Override
    public  List<UserModel> queryList(UserModel temp){
        return userMapper.queryList(temp);
    }

}
