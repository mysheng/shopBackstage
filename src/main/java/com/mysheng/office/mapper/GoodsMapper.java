package com.mysheng.office.mapper;
import com.mysheng.office.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    /**
     * 查询全部商品
     * @return
     */
    List<Goods> queryGoods();

    /**
     * 根据id查询商品
     * @param goodsId
     * @return
     */
    Goods queryGoodsById(String goodsId);

    /**
     * 根据商品名称模糊搜索支持拼音检索
     * @param goodsName
     * @return
     */
    List<Goods> queryGoodsByName(@Param("searchName") String goodsName);
    /**
     * 根据商品名称拼音检索
     * @param goodsName
     * @return
     */
    List<Goods> queryGoodsByPinyin(@Param("searchName") String goodsName);


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
     * 根据商品id删除商品信息
     * @param ids
     * @return
     */
    int deleteGoods(List<String> ids);

    /**
     * 更具goodsId查询图片地址
     * @param goodsId
     * @return
     */
    String findGoodsImageUrl(String goodsId);

}
