package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.TokenMapper;
import com.mysheng.office.model.TokenModel;
import com.mysheng.office.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private TokenMapper tokenMapper;

    @Override
    public List<TokenModel> queryToken() {
        return tokenMapper.queryToken();
    }

    @Override
    public TokenModel queryTokenById(String userId) {
        return tokenMapper.queryTokenById(userId);
    }

    @Override
    public TokenModel queryTokenByOpenid(String openid) {
        return tokenMapper.queryTokenByOpenid(openid);
    }

    @Override
    public int insertTokenModel(TokenModel tokenModel) {
        return tokenMapper.insertToken(tokenModel);
    }

    @Override
    public int updateToken(TokenModel tokenModel) {
        return tokenMapper.updateToken(tokenModel);
    }

    @Override
    public int deleteToken(String userId) {
        return tokenMapper.deleteToken(userId);
    }
}
