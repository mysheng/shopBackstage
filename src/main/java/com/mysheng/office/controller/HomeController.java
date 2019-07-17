package com.mysheng.office.controller;

import com.mysheng.office.model.*;
import com.mysheng.office.service.*;
import com.mysheng.office.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/home")
public class HomeController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BannerService bannerService;

    @Autowired
    private NavigationService navigationService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private SeckillService seckillService;

    @Autowired
    private GoodShopService findshopService;

    @Autowired
    private LiveAndShopingService liveAndShopingService;

    @Autowired
    private GoodsService goodsService;

    @PostMapping(value = "/index")
    public Result findAllUser(){
        logger.info("调用用首页接口开始!");
        //Map<String,Object> map = new HashMap<String,Object>();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = sdf.format(new Date());

        //轮播图
        List<BannerModel> bannerList = bannerService.queryBanner(new Date());

//        //导航
//        List<Navigation> navigationList =  navigationService.selectIndexNavigation();
//
//        //促销
//        List<Promotion> promotionList = promotionService.selectIndexPromotion(date);
//
//        //秒杀
//        List<Seckill> seckillList = seckillService.selectIndexSeckill(date);
//
//        //发现好店
//        List<GoodShop> findshopList = findshopService.selectIndexFindshop(date);

        //map.put("bannerList",bannerList);
//        map.put("navigationList",navigationList);
//        map.put("promotionList",promotionList);
//        map.put("seckillList",seckillList);
//        map.put("findshopList",findshopList);
        logger.info("调用首页接口结束!");
       return ResultUtil.success(0,"查询成功",bannerList);
    };

}
