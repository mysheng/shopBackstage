package com.mysheng.office.service;

import com.mysheng.office.model.Goods;
import com.mysheng.office.model.GoodsData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    /**
     * 查询全部商品
     * @return
     */
    List<Goods> queryGoods();

    /**
     *
     * @param searchName
     * @return
     */
    List<Goods> searchGoods(String searchName);

    /**
     * 根据商品id查询商品
     * @param goodsId
     * @return
     */
    Goods queryGoodsById(String goodsId);

    /**
     * 新增商品
     * @param goods
     * @return
     */
    int insertGoods(Goods goods);

    /**
     * 根据商品id修改商品信息
     * @param goods
     * @return
     */
    int updateGoods(Goods goods);

    /**
     * 根据商品id删除商品
     * @param goodsId
     * @return
     */
    int deleteGoods(List<String> goodsId);

    /**
     * 更具id查询图片地址
     * @param goodsId
     * @return
     */
    String findGoodsImageUrl(String goodsId);

    /**
     * 增加商品库商品
     * @param goodsData
     * @return
     */
    int insertGoodsData(GoodsData goodsData);

    /**
     * 查询商品库所有商品
     * @return
     */
    List<GoodsData>queryGoodsData(String goodsPinyin,String goodsNorms,String goodsUnit);
    /**
     *
     * @param searchName
     * @return
     */
    List<GoodsData> searchGoodsData(String searchName);
    /**
     * 根据商品库id查询商品
     * @param goodsId
     * @return
     */
    GoodsData queryGoodsDataById(String goodsId);
    /**
     * 根据商品库id修改商品信息
     * @param goodsData
     * @return
     */
    int updateGoodsData(GoodsData goodsData);

    /**
     * 根据商品id删除商品
     * @param goodsId
     * @return
     */
    int deleteGoodsData(List<String> goodsId);

    /**
     * 根据商品库条形码查询商品
     * @param goodsCode
     * @return
     */
    GoodsData queryGoodsDataByCode(String goodsCode);
}
