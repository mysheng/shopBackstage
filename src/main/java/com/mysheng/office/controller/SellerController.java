package com.mysheng.office.controller;

import com.mysheng.office.model.Result;
import com.mysheng.office.model.Seller;
import com.mysheng.office.service.SellerService;
import com.mysheng.office.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Result<Seller> findAllUser(){
        List<Seller>list=sellerService.querySeller();
        if(list.size()>0){
            return ResultUtil.success(1,"查询成功",list);
        }
        return ResultUtil.success(0,"没有查到用户");
    }
    @GetMapping(value = "/byId")
    public Result findById(@RequestParam("id") Integer id){
        Seller seller=sellerService.querySellerById(id);
        if(seller!=null){
            return ResultUtil.success(1,"查询成功",seller);
        }else{
            return ResultUtil.success(0,"没找到对应的用户");
        }

    }
    @PostMapping(value = "/addSeller")
    public Result addSeller(@RequestBody Seller seller){
        int num=sellerService.insertSeller(seller);
        if(num>0){
            return ResultUtil.success(1,"商家注册成功");
        }
       return ResultUtil.success(0,"商家注册失败");
    }
    @PostMapping(value = "/update")
    public Result updateSeller(@RequestBody Seller seller){
        int num=sellerService.updateSeller(seller);
        if(num>0){
            return ResultUtil.success(1,"修改商家信息成功");
        }
        return ResultUtil.success(0,"修改商家信息失败");

    }
    @PostMapping(value = "/updatePw")
    public Result updateSellerPassword(@RequestBody Map<String,Object> params){
        String sellerPassword = params.get("sellerPassword").toString();
        String oldPassword = params.get("oldPassword").toString();
        Integer sellerId = (Integer) params.get("sellerId");
        int num=sellerService.updateSellerPassword(oldPassword,sellerPassword,sellerId);
        if (num==1){
            return ResultUtil.success(1,"修改商家密码成功");
        }
        return ResultUtil.success(0,"愿密码不正确");
    }
    @PostMapping(value = "/loginSellerInfo")
    public Result loginSellerInfo(@RequestBody Map<String,Object> params){
        String phone = params.get("phone").toString();
        String password = params.get("sellerPassword").toString();
        int num=sellerService.loginInfo(phone,password);
        if (num==1){
            return ResultUtil.success(1,"登陆成功");
        }
        return ResultUtil.success(0,"密码或手机号不正确");
    }
    @GetMapping(value = "/delete")
    public Result deleteSeller(Integer id){
        int num=sellerService.deleteSeller(id);
        if (num==1){
            return ResultUtil.success(1,"删除用户成功");
        }
        return ResultUtil.success(0,"删除用户失败");
    }
}
