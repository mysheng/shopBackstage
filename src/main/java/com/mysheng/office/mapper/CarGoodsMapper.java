package com.mysheng.office.mapper;

import com.mysheng.office.model.CarGoodsModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CarGoodsMapper {

    /**
     * 根据用户id查询
     * @return
     */
    List<CarGoodsModel> queryCarGoodsByUser(@Param("userId")String userId,@Param("shopId")String shopId);

    /**
     * 根据商品id和类型差商品
     * @param goodsId
     * @param goodsType
     * @return
     */
    CarGoodsModel queryCarGoodsByGoodsIdAndType(@Param("userId") String userId , @Param("goodsId")String goodsId , @Param("goodsType")String goodsType);


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
    /**
     * 按shopId分组 返回分组的shopId
     *
     */
    List<String> getShopId(String userId);
}
