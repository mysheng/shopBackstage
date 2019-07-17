package com.mysheng.office.mapper;
import com.mysheng.office.model.Goods;
import com.mysheng.office.model.GoodsNorms;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsNormsMapper {
    /**
     * 查询商品
     * @return
     */
    List<GoodsNorms> queryGoodsNorms(@Param("goodsId")String goodsId);

    /**
     * 根据商品id查询商品规格
     * @param goodsId
     * @return
     */
    List<GoodsNorms>  queryGoodsNormsByCode(@Param("goodsId")String goodsId, @Param("normsCode") int code);

    /**
     * 新增商品规格
     * @param goodsNorms
     * @return
     */
    int insertGoodsNorms(GoodsNorms goodsNorms);

    /**
     * 根据商品id修改商品信息
     * @param goodsNorms
     * @return
     */
    int updateGoodsNorms(GoodsNorms goodsNorms);
    /**
     * 根据商品id删除商品信息
     * @param ids
     * @return
     */
    int deleteGoodsNorms(List<String> ids);


}
