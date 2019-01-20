package com.mysheng.office.controller;

import com.mysheng.office.base.BaseControllor;
import com.mysheng.office.base.Results;
import com.mysheng.office.model.*;
import com.mysheng.office.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/home")
public class HomeController extends BaseControllor{
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
    private FindshopService findshopService;

    @Autowired
    private LiveAndShopingService liveAndShopingService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public void findAllUser(){
        logger.info("调用用首页接口开始!");
        Map<String,Object> map = new HashMap<String,Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());

        //轮播图
        List<Banner> bannerList = bannerService.selectIndexBanner(date);

        //导航
        List<Navigation> navigationList =  navigationService.selectIndexNavigation();

        //促销
        List<Promotion> promotionList = promotionService.selectIndexPromotion(date);

        //秒杀
        List<Seckill> seckillList = seckillService.selectIndexSeckill(date);

        //发现好店
        List<Findshop> findshopList = findshopService.selectIndexFindshop(date);

        map.put("bannerList",bannerList);
        map.put("navigationList",navigationList);
        map.put("promotionList",promotionList);
        map.put("seckillList",seckillList);
        map.put("findshopList",findshopList);
        logger.info("调用首页接口结束!");
        returnJson(Results.success(map));
    };

    @RequestMapping(value = "/getLiveAndShoping",method = RequestMethod.GET)
    public void getLiveAndShoping(Integer pageNo,Integer pageSize){
        logger.info("调用用首页getLiveAndShoping接口开始!");
        Map<String,Object> map = new HashMap<String,Object>();
        List<LiveAndShoping> liveAndShopingList = liveAndShopingService.findAll();


        List<Goods> goods = goodsService.queryGoodsPage( pageNo,pageSize);
        map.put("liveAndShopingList",liveAndShopingList);
        map.put("goods",goods);
        logger.info("调用首页getLiveAndShoping接口结束!");
        returnJson(Results.success(map));
    }

    @RequestMapping(value = "/findSeckillList",method = RequestMethod.GET)
    public void findSeckillList(){
        Map<String,Object> map = new HashMap<String,Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(new Date());
        //秒杀
        List<Seckill> seckillList = seckillService.selectIndexSeckill(date);
        map.put("seckillList",seckillList);
        returnJson(Results.success(map));
    }

    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.println(sdf.format(d));

    }


}
