package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.CarGoodsMapper;
import com.mysheng.office.model.CarGoodsModel;
import com.mysheng.office.model.ShopCarModel;
import com.mysheng.office.service.CarShopService;
import com.mysheng.office.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CarShopServiceImpl  implements CarShopService{
    @Autowired
    private CarGoodsMapper carGoodsMapper;
    @Override
    public List<ShopCarModel> queryCarGoodsByUser(String userId) {
        List<String> list=carGoodsMapper.getShopId(userId);
        List<ShopCarModel> shopCarList=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            ShopCarModel shopCarModel=new ShopCarModel();
            shopCarModel.setShopId(list.get(i));
            shopCarModel.setShopName("小米旗舰店"+i);
            shopCarModel.setTelephone("1570157098"+i);
            shopCarModel.setShopSelected(true);
            shopCarModel.setCarGoodsModel(carGoodsMapper.queryCarGoodsByUser(userId,list.get(i)));

            shopCarList.add(shopCarModel);
        }
        return shopCarList;
    }

    @Override
    public CarGoodsModel isSameGoods(String userId,String goodsId, String goodsType) {
        CarGoodsModel carGoodsModel=carGoodsMapper.queryCarGoodsByGoodsIdAndType(userId,goodsId,goodsType);


       return carGoodsModel;
    }


    @Override
    public int insertCarGoodsModel(CarGoodsModel carGoodsModel) {
        carGoodsModel.setId(UUIDUtil.getUUID());
        return carGoodsMapper.insertCarGoodsModel(carGoodsModel);
    }

    @Override
    public int updateCarGoodsModel(CarGoodsModel carGoodsModel) {

        return carGoodsMapper.updateCarGoodsModel(carGoodsModel);
    }

    @Override
    public int deleteCarGoodsModel(String userId, String id) {
        return carGoodsMapper.deleteCarGoodsModel(userId,id);
    }
}
