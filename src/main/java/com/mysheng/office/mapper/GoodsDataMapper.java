package com.mysheng.office.mapper;
import com.mysheng.office.model.Goods;
import com.mysheng.office.model.GoodsData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDataMapper {
    /**
     * 查询全部商品库
     * @return
     */
    List<GoodsData> queryGoodsData(@Param("goodsPinyin") String goodsPinyin,@Param("goodsNorms") String goodsNorms,@Param("goodsUnit") String goodsUnit);

    /**
     * 根据id查询商品库
     * @param GoodsDataId
     * @return
     */
    GoodsData queryGoodsDataById(String GoodsDataId);
    /**
     * 根据商品编码查询商品库
     * @param goodsCode
     * @return
     */
    GoodsData queryGoodsDataByCode(String goodsCode);

    /**
     * 根据商品库名称模糊搜索支持拼音检索
     * @param GoodsDataName
     * @return
     */
    List<GoodsData> queryGoodsDataByName(@Param("searchName") String GoodsDataName);
    /**
     * 根据商品名称拼音检索
     * @param GoodsDataName
     * @return
     */
    List<GoodsData> queryGoodsDataByPinyin(@Param("searchName") String GoodsDataName);


    /**
     * 新增商品库
     * @param GoodsData
     * @return
     */
    int insertGoodsData(GoodsData GoodsData);

    /**
     * 根据商品库id修改商品信息
     * @param GoodsData
     * @return
     */
    int updateGoodsData(GoodsData GoodsData);
    /**
     * 根据商品库id删除商品信息
     * @param ids
     * @return
     */
    int deleteGoodsData(List<String> ids);

    /**
     * 更具GoodsDataId查询图片地址
     * @param GoodsDataId
     * @return
     */
    String findGoodsDataImageUrl(String GoodsDataId);

}
