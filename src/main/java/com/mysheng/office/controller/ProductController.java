package com.mysheng.office.controller;

import com.mysheng.office.model.GoodsMsg;
import com.mysheng.office.model.Result;
import com.mysheng.office.service.GoodsMsgService;
import com.mysheng.office.service.RedisService;
import com.mysheng.office.util.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "/wares")
public class ProductController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private GoodsMsgService goodsMsgService;


    @PostMapping(value = "/saveGoods")
    public Result saveGoodsMsg(HttpServletRequest request, @RequestBody GoodsMsg goodsMsg) {
        String token = request.getHeader("token");
        String userId = (String) redisService.get(token);
        goodsMsg.setUserId(userId);
        if (goodsMsg.getId() != null) {
            goodsMsgService.insertGoodsMsg(goodsMsg);
        } else {
            goodsMsgService.insertGoodsMsg(goodsMsg);
        }

        return ResultUtil.success(0, "保存成功");
    }




}
