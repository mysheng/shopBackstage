package com.mysheng.office.controller;

import com.mysheng.office.model.Classify;
import com.mysheng.office.model.CouponModel;
import com.mysheng.office.model.Result;
import com.mysheng.office.service.ClassifyService;
import com.mysheng.office.service.RedisService;
import com.mysheng.office.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/classify")
public class ClassifyController {

    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private RedisService redisService;

    @PostMapping(value = "/list")
    public Result<Classify> findClassifyList(){
        long num=System.currentTimeMillis();
        logger.error(num+"");
        List<Classify> classifies= (List<Classify>) redisService.get("classify");
        if(classifies==null){
            classifies=classifyService.queryClassify(0);
            redisService.set("classify",classifies);
        }
        if(classifies.size()>0){
            long num2=System.currentTimeMillis();
            logger.error(num2-num+"");

            return ResultUtil.success(0,"查询成功",classifies);
        }
        return ResultUtil.success(1,"没有数据");
    }
}
