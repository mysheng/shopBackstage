package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.GoodShopMapper;
import com.mysheng.office.model.GoodShop;
import com.mysheng.office.service.GoodShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodShopServiceImpl implements GoodShopService {

    @Autowired
    private GoodShopMapper goodShopMapper;

    @Override
    public List<GoodShop> queryGoodShop(Date date) {
        return goodShopMapper.queryGoodShop(date);
    }

}
