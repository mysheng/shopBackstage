package com.mysheng.office.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysheng.office.model.ChatModel;
import com.mysheng.office.model.Goods;
import com.mysheng.office.model.Result;
import com.mysheng.office.service.GoodsService;
import com.mysheng.office.util.PageBean;
import com.mysheng.office.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @GetMapping(value = "/findGoods")
    public Result<PageBean<Goods>> findAllGoods(@RequestParam("currIndex") Integer currIndex, @RequestParam("pageSize") Integer pageSize){
        PageHelper.startPage(currIndex, pageSize);
        List<Goods>list=goodsService.queryGoods();
        PageInfo<Goods> pageInfo = new PageInfo<>(list);
        if(list.size()>0){
            return ResultUtil.success(1,"查询成功！",pageInfo);
        }
        return ResultUtil.success(0, "没有查询到数据");
    }
    @GetMapping(value = "/byId")
    public Result findById(@RequestParam("id") Integer id){
        Goods goods=goodsService.queryGoodsById(id);
        if(goods!=null){
            return ResultUtil.success(1,"查询成功",goods);
        }else{
            return ResultUtil.success(0,"没找到对应的用户");
        }

    }
    @PostMapping(value = "/addGoods")
    public Result addGoods(@RequestBody Goods goods){
        int num=goodsService.insertGoods(goods);
        if(num>0){
            return ResultUtil.success(1,"增加商品成功");
        }
        return ResultUtil.success(0,"增加商品失败");
    }
    @PostMapping(value = "/update")
    public Result updateGoods(@RequestBody Goods goods){
        int num=goodsService.updateGoods(goods);
        if(num>0){
            return ResultUtil.success(1,"修改商品信息成功");
        }
        return ResultUtil.success(0,"修改商品信息失败");

    }
    @GetMapping(value = "/delete")
    public Result deleteSeller(int[] id){
        if(id.length<1){
            return ResultUtil.success(0,"商品id不能为空");
        }
        int num=goodsService.deleteGoods(id);
        if (num>0){
            return ResultUtil.success(1,"删除商品成功");
        }
        return ResultUtil.success(0,"删除商品失败");
    }
}
