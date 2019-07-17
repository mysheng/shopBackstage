package com.mysheng.office.service.impl;

import com.mysheng.office.enums.ResultError;
import com.mysheng.office.exception.CustomException;
import com.mysheng.office.mapper.ShopMapper;
import com.mysheng.office.mapper.UserModelMapper;
import com.mysheng.office.model.ShopModel;
import com.mysheng.office.model.UserModel;
import com.mysheng.office.service.ShopService;
import com.mysheng.office.util.PinYinUtil;
import com.mysheng.office.util.UUIDUtil;
import com.mysheng.office.util.UtilsCodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private UserModelMapper userMapper;

    @Override
    public List<ShopModel> queryShop() {
        return shopMapper.queryShop();
    }

    @Override
    public  List<ShopModel> queryShopByUser(String userId) {
        return shopMapper.queryShopByUser(userId);
    }

    @Override
    public ShopModel queryShopById(String shopId) {
        return shopMapper.queryShopById(shopId);
    }

    @Override
    public int insertShop(ShopModel shopModel) {
        String phone=userMapper.queryUserPhoneById(shopModel.getUserId());
        shopModel.setShopCode(UtilsCodeFactory.getShopCodeNum(phone));
        shopModel.setId(UUIDUtil.getUUID());
        shopModel.setShopPinyin(PinYinUtil.toFirstChar(shopModel.getShopName()));
        shopModel.setBrandPinyin(PinYinUtil.toFirstChar(shopModel.getBrandName()));
        return shopMapper.insertShop(shopModel);
    }

    @Override
    public int updateShop(ShopModel shopModel) {
        return shopMapper.updateShop(shopModel);
    }

    @Override
    public int deleteShop(String shopId) {
        return shopMapper.deleteShop(shopId);
    }

    @Override
    public int updateShopStatus(String shopId, int status) {
        return shopMapper.updateShopStatus(shopId,status);
    }
}
