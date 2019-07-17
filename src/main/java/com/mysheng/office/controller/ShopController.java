package com.mysheng.office.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mysheng.office.base.RequestLimit;
import com.mysheng.office.model.Result;
import com.mysheng.office.model.ShopModel;
import com.mysheng.office.service.RedisService;
import com.mysheng.office.service.ShopService;
import com.mysheng.office.util.PageBean;
import com.mysheng.office.util.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private RedisService redisService;
    @PostMapping(value = "/shopAll")
    public Result<ShopModel> findAllUser(@RequestBody Map<String ,Integer> map){
        int currentPage=map.get("currentPage");
        int pageSize=map.get("pageSize");
        Page page= PageHelper.startPage(currentPage,pageSize);
        List<ShopModel>list=shopService.queryShop();
        PageBean<ShopModel> pageBean=new PageBean<>(currentPage,pageSize,page.getTotal());
        pageBean.setItems(list);
        if(list.size()>0){

            return ResultUtil.success(0,"查询成功",pageBean);
        }
        return ResultUtil.success(1,"没有查到数据");
    }
    @PostMapping(value = "/findShop")
    public Result findByUser(HttpServletRequest request){
        String token=request.getHeader("token");
        String userId= (String) redisService.get(token);
        List<ShopModel> shopModels =shopService.queryShopByUser(userId);
        if(shopModels.size()>0){
            return ResultUtil.success(0,"查询成功", shopModels);
        }else{
            return ResultUtil.success(1,"没有找到相关店铺");
        }

    }
    @GetMapping(value = "/shopById")
    public Result findById(@RequestParam("id") String id){
        ShopModel shopModel =shopService.queryShopById(id);
        if(shopModel !=null){
            return ResultUtil.success(0,"查询成功", shopModel);
        }else{
            return ResultUtil.success(1,"没找到对应的用户");
        }

    }
    @RequestLimit(count = 2)
    @PostMapping(value = "/updateStatus")
    public Result shopStatus(@RequestBody Map<String ,Object> map){
        String shopId= (String) map.get("id");
        int status= (int) map.get("status");

        String message="";
        if(status==0){
            status=1;
            message="店铺已暂停营业";
        }else if(status==1){
            status=0;
            message="开始营业成功";
        }else{
            message="请您续费";
            return ResultUtil.success(0,message);
        }
        int  num =shopService.updateShopStatus(shopId,status);
        if(num==1){
            return ResultUtil.success(0,message);
        }else{
            return ResultUtil.success(1,message);
        }

    }
    @PostMapping(value = "/saveShop")
    public Result addShop(HttpServletRequest request, @RequestBody ShopModel shopModel){
        String token=request.getHeader("token");
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(-1,"请您登陆");
        }
        shopModel.setUserId(userId);
        int num=0;
        if(shopModel.getId()!=null){
            num=shopService.updateShop(shopModel);
        }else {
            num=shopService.insertShop(shopModel);
        }

        if(num>0){
            return ResultUtil.success(0,"保存成功");
        }
       return ResultUtil.success(1,"保存失败");
    }


    @GetMapping(value = "/delete")
    public Result deleteShop(String id){
        int num=shopService.deleteShop(id);
        if (num==1){
            return ResultUtil.success(0,"删除用户成功");
        }
        return ResultUtil.success(1,"删除用户失败");
    }
}
