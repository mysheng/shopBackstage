package com.mysheng.office.mapper;
import com.mysheng.office.model.Goods;
import com.mysheng.office.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    /**
     * 查询全部用户
     * @return
     */
    List<Goods> queryGoods();

    /**
     * 根据用户id查询用户
     * @param goodsId
     * @return
     */
    Goods queryGoodsById(int goodsId);

    /**
     * 新增用户
     * @param goods
     * @return
     */
    int insertGoods(Goods goods);

    /**
     * 根据用户id修改用户信息
     * @param goods
     * @return
     */
    int updateGoods(Goods goods);
    /**
     * 根据用户id修改用户信息
     * @param ids
     * @return
     */
    int deleteGoods(int[] ids);

    /**
     * 更具goodsId查询图片地址
     * @param goodsId
     * @return
     */
    String findGoodsImageUrl(int goodsId);
}
