package com.mysheng.office.service;

import com.mysheng.office.model.ShopModel;

import java.util.List;

public interface ShopService {
    /**
     * 查询全部用户
     * @return
     */
    List<ShopModel> queryShop();

    /**
     * 根据用户id查询店铺
     * @param userId
     * @return
     */
    List<ShopModel> queryShopByUser(String userId);

    /**
     * 根据用户id查询用户
     * @param shopId
     * @return
     */
    ShopModel queryShopById(String shopId);

    /**
     * 新增用户
     * @param shopModel
     * @return
     */
    int insertShop(ShopModel shopModel);

    /**
     * 根据用户id修改用户信息
     * @param shopModel
     * @return
     */
    int updateShop(ShopModel shopModel);

    /**
     * 根据用户id删除用户
     * @param shopId
     * @return
     */
    int deleteShop(String shopId);

    int updateShopStatus(String shopId,int status);


}
