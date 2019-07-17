package com.mysheng.office.service;

import com.mysheng.office.model.GoodShop;

import java.util.Date;
import java.util.List;

public interface GoodShopService {
    List<GoodShop> queryGoodShop(Date date);
}
