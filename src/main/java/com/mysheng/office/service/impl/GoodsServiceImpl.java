package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.GoodsDataMapper;
import com.mysheng.office.mapper.GoodsMapper;
import com.mysheng.office.model.Goods;
import com.mysheng.office.model.GoodsData;
import com.mysheng.office.service.GoodsService;
import com.mysheng.office.util.PinYinUtil;
import com.mysheng.office.util.RegexUtils;
import com.mysheng.office.util.UUIDUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsDataMapper goodsDataMapper;
    @Override
    public List<Goods> queryGoods() {
        return goodsMapper.queryGoods();
    }

    @Override
    public List<Goods> searchGoods(String searchName) {
        if(RegexUtils.checkLetter(searchName)){

            return goodsMapper.queryGoodsByPinyin(searchName.toUpperCase());
        }
        return goodsMapper.queryGoodsByName(searchName);
    }
    @Override
    public Goods queryGoodsById(String goodsId) {
        return goodsMapper.queryGoodsById(goodsId);
    }

    @Override
    public int insertGoods(Goods goods) {

        goods.setId(UUIDUtil.getUUID());
        goods.setGoodsPinyin(PinYinUtil.toFirstChar(goods.getGoodsName()));

        return goodsMapper.insertGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int deleteGoods(List<String>goodsIds) {
        return goodsMapper.deleteGoods(goodsIds);
    }

    @Override
    public String findGoodsImageUrl(String goodsId) {
        return goodsMapper.findGoodsImageUrl(goodsId);
    }

    @Override
    public int insertGoodsData(GoodsData goodsData) {
        goodsData.setId(UUIDUtil.getUUID());
        goodsData.setGoodsPinyin(PinYinUtil.toFirstChar(goodsData.getGoodsName()));
        return goodsDataMapper.insertGoodsData(goodsData);
    }

    @Override
    public List<GoodsData> queryGoodsData(String goodsPinyin,String goodsNorms,String goodsUnit) {

        return goodsDataMapper.queryGoodsData(goodsPinyin,goodsNorms,goodsUnit);
    }

    @Override
    public List<GoodsData> searchGoodsData(String searchName) {
        if(RegexUtils.checkLetter(searchName)){

            return goodsDataMapper.queryGoodsDataByPinyin(searchName.toUpperCase());
        }
        return goodsDataMapper.queryGoodsDataByName(searchName);
    }

    @Override
    public GoodsData queryGoodsDataById(String goodsId) {
        return goodsDataMapper.queryGoodsDataById(goodsId);
    }

    @Override
    public int updateGoodsData(GoodsData goodsData) {
        return goodsDataMapper.updateGoodsData(goodsData);
    }

    @Override
    public int deleteGoodsData(List<String> goodsIds) {
        return goodsDataMapper.deleteGoodsData(goodsIds);
    }

    @Override
    public GoodsData queryGoodsDataByCode(String goodsCode) {
        return goodsDataMapper.queryGoodsDataByCode(goodsCode);
    }


}
