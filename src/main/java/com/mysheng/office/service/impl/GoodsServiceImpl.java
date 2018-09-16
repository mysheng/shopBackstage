package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.GoodsMapper;
import com.mysheng.office.model.Goods;
import com.mysheng.office.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> queryGoods() {
        return goodsMapper.queryGoods();
    }

    @Override
    public Goods queryGoodsById(int goodsId) {
        return goodsMapper.queryGoodsById(goodsId);
    }

    @Override
    public int insertGoods(Goods goods) {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String goodsNum=df.format(date)+Math.ceil(Math.random()*9+1)*100000;
        goods.setGoodsNum(goodsNum);
        return goodsMapper.insertGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        Date date=new Date();
        goods.setUpdateDate(date);
        return goodsMapper.updateGoods(goods);
    }

    @Override
    public int deleteGoods(int[] goodsIds) {
        return goodsMapper.deleteGoods(goodsIds);
    }

    @Override
    public String findGoodsImageUrl(int goodsId) {
        return goodsMapper.findGoodsImageUrl(goodsId);
    }
}
