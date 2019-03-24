package com.mysheng.office.service;

import com.mysheng.office.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
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
     * 根据用户id删除用户
     * @param goodsId
     * @return
     */
    int deleteGoods(int[] goodsId);

    /**
     * 更具id查询图片地址
     * @param goodsId
     * @return
     */
    String findGoodsImageUrl(int goodsId);

    List<Goods> queryGoodsPage(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
}
