package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.GoodsDataMapper;
import com.mysheng.office.mapper.GoodsMapper;
import com.mysheng.office.mapper.GoodsMsgMapper;
import com.mysheng.office.model.Goods;
import com.mysheng.office.model.GoodsData;
import com.mysheng.office.model.GoodsMsg;
import com.mysheng.office.service.GoodsMsgService;
import com.mysheng.office.service.GoodsService;
import com.mysheng.office.util.PinYinUtil;
import com.mysheng.office.util.RegexUtils;
import com.mysheng.office.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GoodsMsgServiceImpl implements GoodsMsgService{
    @Autowired
    private GoodsMsgMapper goodsMsgMapper;

    @Override
    public List<GoodsMsg> queryGoodsMsg() {
        return goodsMsgMapper.queryGoodsMsg();
    }

    @Override
    public List<GoodsMsg> searchGoodsMsg(String searchName) {
        if(RegexUtils.checkLetter(searchName)){

            return goodsMsgMapper.queryGoodsMsgByPinyin(searchName.toUpperCase());
        }
        return goodsMsgMapper.queryGoodsMsgByName(searchName);
    }

    @Override
    public GoodsMsg queryGoodsMsgById(String goodsId) {
        return goodsMsgMapper.queryGoodsMsgById(goodsId);
    }

    @Override
    public int insertGoodsMsg(GoodsMsg goods) {
        goods.setId(UUIDUtil.getUUID());
        goods.setGoodsPinyin(PinYinUtil.toFirstChar(goods.getGoodsName()));
        return goodsMsgMapper.insertGoodsMsg(goods);
    }

    @Override
    public int updateGoodsMsg(GoodsMsg goods) {
        return goodsMsgMapper.updateGoodsMsg(goods);
    }

    @Override
    public int deleteGoodsMsg(List<String> goodsId) {
        return goodsMsgMapper.deleteGoodsMsg(goodsId);
    }

    @Override
    public String findGoodsMsgImageUrl(String goodsId) {
        return null;
    }
}
