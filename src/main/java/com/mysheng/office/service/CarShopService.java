package com.mysheng.office.service;

import com.mysheng.office.model.CarGoodsModel;
import com.mysheng.office.model.ShopCarModel;

import java.util.List;

public interface CarShopService {

    /**
     * 根据用户id查询
     * @return
     */
    List<ShopCarModel> queryCarGoodsByUser(String userId);

    /**
     * 判断是否为同一个商品
     * @param goodsId
     * @param goodsType
     * @return
     */
    CarGoodsModel isSameGoods(String userId,String goodsId ,String goodsType);


    /**
     * 加入购物车
     * @param carGoodsModel
     * @return
     */
    int insertCarGoodsModel(CarGoodsModel carGoodsModel);

    /**
     * 更新商品
     * @param carGoodsModel
     * @return
     */
    int updateCarGoodsModel(CarGoodsModel carGoodsModel);


    /**
     * 根据id删除购物车中的商品
     * @param userId
     * @return
     */
    int deleteCarGoodsModel(String userId,String id);
}
