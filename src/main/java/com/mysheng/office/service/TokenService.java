package com.mysheng.office.service;

import com.mysheng.office.model.TokenModel;

import java.util.List;

public interface TokenService {
    /**
     * 查询全部用户
     * @return
     */
    List<TokenModel> queryToken();

    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    TokenModel queryTokenById(String userId);

    /**
     * 根据openid查询token
     * @param openid
     * @return
     */
    TokenModel queryTokenByOpenid(String openid);

    /**
     * 新增用户
     * @param tokenModel
     * @return
     */
    int insertTokenModel(TokenModel tokenModel);

    /**
     * 根据用户id修改用户信息
     * @param tokenModel
     * @return
     */
    int updateToken(TokenModel tokenModel);

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    int deleteToken(String userId);


}
