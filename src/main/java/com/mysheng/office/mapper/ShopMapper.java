package com.mysheng.office.mapper;

import com.mysheng.office.model.ShopModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ShopMapper {
    /**
     * 查询全部商家
     */
    List<ShopModel>queryShop();

    /**
     * 根据用户id查询店铺
     * @return
     */
    List<ShopModel>queryShopByUser(String userId);
    /**
     * 根据店铺id查询店铺
     * @param sellerId
     * @return
     */
    ShopModel queryShopById(String sellerId);

    /**
     * 新增店铺
     * @param shopModel
     * @return
     */
    int insertShop(ShopModel shopModel);

    /**
     * 根据店铺id修改商家信息
     * @param shopModel
     * @return
     */
    int updateShop(ShopModel shopModel);
    /**
     * 修改商家状态
     * @param shopId
     * @return
     */
    int updateShopStatus(@Param("id") String shopId, @Param("status")int status);

    /**
     * 根据店铺id删除店铺
     * @param shopId
     * @return
     */
    int deleteShop(String shopId);


}
