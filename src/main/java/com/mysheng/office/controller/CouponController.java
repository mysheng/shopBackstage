package com.mysheng.office.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mysheng.office.model.Result;
import com.mysheng.office.model.CouponModel;
import com.mysheng.office.service.RedisService;
import com.mysheng.office.service.CouponService;
import com.mysheng.office.util.PageBean;
import com.mysheng.office.util.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;
    @Autowired
    private RedisService redisService;
    @PostMapping(value = "/couponAll")
    public Result<CouponModel> findAllUser(@RequestBody Map<String ,Object> map){
        int currentPage= (int) map.get("currentPage");
        int pageSize= (int) map.get("pageSize");
        Page page= PageHelper.startPage(currentPage,pageSize);
        List<CouponModel>list=couponService.queryCoupon(map);
        PageBean<CouponModel> pageBean=new PageBean<>(currentPage,pageSize,page.getTotal());
        pageBean.setItems(list);
        if(list.size()>0){

            return ResultUtil.success(0,"查询成功",pageBean);
        }
        return ResultUtil.success(1,"没有查到数据");
    }
    @GetMapping(value = "/getCoupon")
    public Result findById(@RequestParam("id") String id){
        CouponModel CouponModel =couponService.queryCouponById(id);
        if(CouponModel !=null){
            return ResultUtil.success(0,"查询成功", CouponModel);
        }else{
            return ResultUtil.success(1,"没有数据");
        }

    }
    @PostMapping(value = "/createCoupon")
    public Result addCoupon(HttpServletRequest request, @RequestBody CouponModel couponModel){
        String token=request.getHeader("token");
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(-1,"请您登陆");
        }
        couponModel.setUserId(userId);
        int num=couponService.insertCoupon(couponModel);
        if(num>0){
            return ResultUtil.success(0,"创建成功");
        }
       return ResultUtil.success(1,"创建失败");
    }
    @PostMapping(value = "/update")
    public Result updateCoupon(@RequestBody CouponModel couponModel){
        int num=couponService.updateCoupon(couponModel);
        if(num>0){
            return ResultUtil.success(0,"修改成功");
        }
        return ResultUtil.success(1,"修改失败");

    }

    @GetMapping(value = "/delete")
    public Result deleteCoupon(@RequestParam("id") String id){
        int num=couponService.deleteCoupon(id);
        if (num==1){
            return ResultUtil.success(0,"删除成功");
        }
        return ResultUtil.success(1,"删除失败");
    }
    @PostMapping(value = "/userCoupon")
    public Result<CouponModel> findUserCoupon(HttpServletRequest request){
        String token=request.getHeader("token");
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(0101,"请您登陆");
        }
        List<CouponModel>list=couponService.queryUserCoupons(userId);
        if(list.size()>0){

            return ResultUtil.success(0,"查询成功",list);
        }
        return ResultUtil.success(1,"没有查到数据");
    }
    @PostMapping(value = "/collarCoupon")
    public Result<CouponModel> collarUserCoupon(HttpServletRequest request,@RequestBody Map<String,String>mapParam){
        String token=request.getHeader("token");
        String couponId=mapParam.get("couponId");
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(0101,"请您登陆");
        }
        int num=couponService.userCollarCoupons(userId,couponId);
        if(num>0){

            return ResultUtil.success(0,"领取成功");
        }
        return ResultUtil.success(1,"领取失败");
    }
    @PostMapping(value = "/userCouponStatus")
    public Result<CouponModel> UserCouponStatus(HttpServletRequest request,@RequestBody Map<String,Integer>mapParam){
        String token=request.getHeader("token");
        int status=mapParam.get("status");
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(0101,"请您登陆");
        }
        List<CouponModel>list=couponService.queryCouponsByStatus(userId,status);
        if(list.size()>0){

            return ResultUtil.success(0,"查询成功",list);
        }
        return ResultUtil.success(1,"没有查到数据");
    }
    @GetMapping(value = "/userDelete")
    public Result deleteUserCoupon(String id){
        int num=couponService.deleteUserCoupon(id);
        if (num==1){
            return ResultUtil.success(0,"删除成功");
        }
        return ResultUtil.success(1,"删除失败");
    }
}
