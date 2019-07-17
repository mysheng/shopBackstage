package com.mysheng.office.service;

import com.mysheng.office.model.Goods;
import com.mysheng.office.model.GoodsData;
import com.mysheng.office.model.GoodsMsg;

import java.util.List;

public interface GoodsMsgService {
    /**
     * 查询全部商品
     * @return
     */
    List<GoodsMsg> queryGoodsMsg();

    /**
     *
     * @param searchName
     * @return
     */
    List<GoodsMsg> searchGoodsMsg(String searchName);

    /**
     * 根据商品id查询商品
     * @param goodsId
     * @return
     */
    GoodsMsg queryGoodsMsgById(String goodsId);

    /**
     * 新增商品
     * @param goods
     * @return
     */
    int insertGoodsMsg(GoodsMsg goods);

    /**
     * 根据商品id修改商品信息
     * @param goods
     * @return
     */
    int updateGoodsMsg(GoodsMsg goods);

    /**
     * 根据商品id删除商品
     * @param goodsId
     * @return
     */
    int deleteGoodsMsg(List<String> goodsId);

    /**
     * 更具id查询图片地址
     * @param goodsId
     * @return
     */
    String findGoodsMsgImageUrl(String goodsId);



}
