package com.mysheng.office.controller;

import com.mysheng.office.model.CarGoodsModel;
import com.mysheng.office.model.Result;
import com.mysheng.office.model.ShopCarModel;
import com.mysheng.office.service.CarShopService;
import com.mysheng.office.service.RedisService;
import com.mysheng.office.util.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/goods")
public class ShopCarController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CarShopService carShopService;

    @Autowired
    private RedisService redisService;
    @PostMapping(value = "/carGoods")
    public Result findUserShopCar(HttpServletRequest request){
        String token=request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            return ResultUtil.success(-1,"缺少参数");
        }
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(1010,"你没登录");
        }
        List<ShopCarModel> ShopCarModels=carShopService.queryCarGoodsByUser(userId);
        return ResultUtil.success(0,"查询成功",ShopCarModels);
    }

    @PostMapping(value = "/add")
    public Result addCarGoods(HttpServletRequest request,@RequestBody CarGoodsModel carGoodsModel){
        String token=request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            return ResultUtil.success(-1,"缺少参数");
        }
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(1010,"你没登录");
        }
        carGoodsModel.setUserId(userId);
        CarGoodsModel carGoodsModel2=carShopService.isSameGoods(userId,carGoodsModel.getGoodsId(),carGoodsModel.getNorms());
        if(carGoodsModel2!=null){
            carGoodsModel2.setGoodsNum(carGoodsModel2.getGoodsNum()+carGoodsModel.getGoodsNum());
            carShopService.updateCarGoodsModel(carGoodsModel2);
            return ResultUtil.success(0,"更新成功");
        }else{
            carShopService.insertCarGoodsModel(carGoodsModel);
            return ResultUtil.success(0,"加入成功");
        }

    }
}
