package com.mysheng.office.mapper;

import com.mysheng.office.model.GoodShop;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface GoodShopMapper {
    List<GoodShop> queryGoodShop(Date date);
}
