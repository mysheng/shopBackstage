package com.mysheng.office.mapper;
import com.mysheng.office.model.Goods;
import com.mysheng.office.model.GoodsMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMsgMapper {
    /**
     * 查询全部商品
     * @return
     */
    List<GoodsMsg> queryGoodsMsg();

    /**
     * 根据id查询商品
     * @param msgId
     * @return
     */
    GoodsMsg queryGoodsMsgById(String msgId);

    /**
     * 根据商品名称模糊搜索支持拼音检索
     * @param msgName
     * @return
     */
    List<GoodsMsg> queryGoodsMsgByName(@Param("searchName") String msgName);
    /**
     * 根据商品名称拼音检索
     * @param msgName
     * @return
     */
    List<GoodsMsg> queryGoodsMsgByPinyin(@Param("searchName") String msgName);


    /**
     * 新增商品
     * @param goodsMsg
     * @return
     */
    int insertGoodsMsg(GoodsMsg goodsMsg);

    /**
     * 根据商品id修改商品信息
     * @param goodsMsg
     * @return
     */
    int updateGoodsMsg(GoodsMsg goodsMsg);
    /**
     * 根据商品id删除商品信息
     * @param ids
     * @return
     */
    int deleteGoodsMsg(List<String> ids);

    /**
     * 更具GoodsMsgId查询图片地址
     * @param goodsMsgId
     * @return
     */
    String findGoodsMsgImageUrl(String goodsMsgId);

}
