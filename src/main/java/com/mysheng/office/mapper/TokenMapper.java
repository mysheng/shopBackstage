package com.mysheng.office.mapper;
import com.mysheng.office.model.TokenModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TokenMapper{
    /**
     * 查询全部token
     * @return
     */
    List<TokenModel> queryToken();

    /**
     * 根据用户id查询token
     * @param userId
     * @return
     */
    TokenModel queryTokenById(String userId);

    /**
     * 更具手机号查询授权状态
     * @param phone
     * @return
     */
    TokenModel queryTokenByPhone(String phone);

    String queryUserIdByToken(String token);
    /**
     * 根据用户openid查询token
     * @param openid
     * @return
     */
    TokenModel queryTokenByOpenid(String openid);

    /**
     * 新增用户
     * @param token
     * @return
     */
    int insertToken(TokenModel token);

    /**
     * 根据用户id修改token信息
     * @param token
     * @return
     */
    int updateToken(TokenModel token);
    /**
     * 根据用户id删除token
     * @param userId
     * @return
     */
    int deleteToken(String userId);

}
