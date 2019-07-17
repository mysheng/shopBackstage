package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.GoodsNormsMapper;
import com.mysheng.office.model.GoodsNorms;
import com.mysheng.office.service.GoodsNormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsNormsServiceImpl implements GoodsNormsService{
    @Autowired
    private GoodsNormsMapper goodsNormsMapper;
    @Override
    public List<GoodsNorms> queryGoodsNorms(String goodsId) {
        return goodsNormsMapper.queryGoodsNorms(goodsId);
    }

    @Override
    public List<GoodsNorms> queryGoodsNormsByCode(String goodsId, int code) {
        return goodsNormsMapper.queryGoodsNormsByCode(goodsId,code);
    }

    @Override
    public int insertGoodsNorms(GoodsNorms goodsNorms) {
        return goodsNormsMapper.insertGoodsNorms(goodsNorms);
    }

    @Override
    public int updateGoodsNorms(GoodsNorms goodsNorms) {
        return goodsNormsMapper.updateGoodsNorms(goodsNorms);
    }

    @Override
    public int deleteGoodsNorms(List<String> ids) {
        return goodsNormsMapper.deleteGoodsNorms(ids);
    }
}
