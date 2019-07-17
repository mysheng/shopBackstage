package com.mysheng.office.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mysheng.office.model.Goods;
import com.mysheng.office.model.GoodsData;
import com.mysheng.office.model.GoodsMsg;
import com.mysheng.office.model.Result;
import com.mysheng.office.service.GoodsMsgService;
import com.mysheng.office.service.GoodsService;
import com.mysheng.office.service.RedisService;
import com.mysheng.office.util.PageBean;
import com.mysheng.office.util.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private RedisService redisService;


    @PostMapping(value = "/findGoods")
    public Result<Goods> findAllGoods(@RequestBody Map<String,Object> mapParam){
        int currentPage= (int) mapParam.get("currentPage");
        int pageSize= (int) mapParam.get("pageSize");
        Page page=PageHelper.startPage(currentPage,pageSize);
        List<Goods>list=goodsService.queryGoods();
        PageBean<Goods> pageBean=new PageBean<Goods>(currentPage,pageSize,page.getTotal());
        pageBean.setItems(list);
        if(list.size()>0){

            return ResultUtil.success(0,"查询成功",pageBean);
        }
        return ResultUtil.success(1,"没有查到数据");
    }

    @PostMapping(value = "/searchGoods")
    public Result<Goods> searchGoods(@RequestBody Map<String,Object> mapParam){
            int currentPage= (int) mapParam.get("currentPage");
            int pageSize= (int) mapParam.get("pageSize");
            Page page= PageHelper.startPage(currentPage,pageSize);
            String search= (String) mapParam.get("searchName");
            List<Goods>list=goodsService.searchGoods(search);
            PageBean<Goods> pageBean=new PageBean<>(currentPage,pageSize,page.getTotal());
            pageBean.setItems(list);

        if(list.size()>0){

            return ResultUtil.success(0,"搜索成功",pageBean);
        }
        return ResultUtil.success(1,"未找到数据");
    }

    @GetMapping(value = "/byId")
    public Result findById(@RequestParam("id") String id){
        Goods goods=goodsService.queryGoodsById(id);
        if(goods!=null){
            return ResultUtil.success(0,"查询成功",goods);
        }else{
            return ResultUtil.success(1,"没找到对应的用户");
        }

    }

    @PostMapping(value = "/addGoods")
    public Result addGoods(HttpServletRequest request,@RequestBody Goods goods){
        String token=request.getHeader("token");
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(-1,"请您登陆");
        }
        goods.setShopId("20190501111199998888");
        goods.setCreateUserId(userId);
        int num=goodsService.insertGoods(goods);
        if(num>0){
            return ResultUtil.success(0,"增加商品成功");
        }
        return ResultUtil.success(1,"增加商品失败");
    }
    @PostMapping(value = "/update")
    public Result updateGoods(HttpServletRequest request,@RequestBody Goods goods){
        String token=request.getHeader("token");
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(-1,"请您登陆");
        }
        goods.setUpdateUserId(userId);
        int num=goodsService.updateGoods(goods);
        if(num>0){
            return ResultUtil.success(0,"修改商品信息成功");
        }
        return ResultUtil.success(1,"修改商品信息失败");

    }
    @PostMapping(value = "/delete")
    public Result deleteGoods(HttpServletRequest request, @RequestBody Map<String,Object> params){
        String token=request.getHeader("token");
        Object id2= params.get("id");
        List<String> id= (List<String>) params.get("id");
        if(id.size()==0){
            return ResultUtil.success(1,"商品id不能为空");
        }
        int num=goodsService.deleteGoods(id);
        if (num>0){
            return ResultUtil.success(0,"删除商品成功");
        }
        return ResultUtil.success(1,"删除商品失败");
    }





    /**商品库操作**/

    @PostMapping(value = "/findGoodsData")
    public Result<GoodsData> findAllGoodsData(@RequestBody Map<String,Object> mapParam){
        int currentPage= (int) mapParam.get("currentPage");
        int pageSize= (int) mapParam.get("pageSize");
        String goodsPinyin= (String) mapParam.get("goodsPinyin");
        String goodsNorms= (String) mapParam.get("goodsNorms");;
        String goodsUnit= (String) mapParam.get("goodsUnit");;
        Page page=PageHelper.startPage(currentPage,pageSize);
        List<GoodsData>list=goodsService.queryGoodsData(goodsPinyin,goodsNorms,goodsUnit);
        PageBean<GoodsData> pageBean=new PageBean<>(currentPage,pageSize,page.getTotal());
        pageBean.setItems(list);
        if(list.size()>0){

            return ResultUtil.success(0,"查询成功",pageBean);
        }
        return ResultUtil.success(1,"没有查到数据");
    }
    @PostMapping(value = "/addGoodsData")
    public Result addGoodsData(HttpServletRequest request,@RequestBody Map<String ,List<GoodsData>> param){
        String token=request.getHeader("token");
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(-1,"请您登陆");
        }
        List<GoodsData> list=param.get("data");
        for (int i=0;i<list.size();i++){
            GoodsData goodsData=list.get(i);
            goodsData.setUserId(userId);
            goodsService.insertGoodsData(goodsData);
        }

        return ResultUtil.success(0,"增加商品成功");
    }
    @PostMapping(value = "/goodsByCode")
    public Result findGoodsDataByCode(@RequestBody Map<String ,String> param){
        String goodsCode=param.get("goodsCode");
        GoodsData goods=goodsService.queryGoodsDataByCode(goodsCode);
        if(goods!=null){
            return ResultUtil.success(0,"查询成功",goods);
        }else{
            return ResultUtil.success(1,"没找到对应的商品");
        }

    }
    @PostMapping(value = "/searchGoodsData")
    public Result<GoodsData> searchGoodsData(@RequestBody Map<String,Object> mapParam){
        int currentPage= (int) mapParam.get("currentPage");
        int pageSize= (int) mapParam.get("pageSize");
        Page page= PageHelper.startPage(currentPage,pageSize);
        String search= (String) mapParam.get("searchName");
        List<GoodsData>list=goodsService.searchGoodsData(search);
        PageBean<GoodsData> pageBean=new PageBean<>(currentPage,pageSize,page.getTotal());
        pageBean.setItems(list);

        if(list.size()>0){

            return ResultUtil.success(0,"搜索成功",pageBean);
        }
        return ResultUtil.success(1,"未找到数据");
    }
    @PostMapping(value = "/updateData")
    public Result updateGoodsData(HttpServletRequest request,@RequestBody GoodsData goodsData){
        String token=request.getHeader("token");
        String userId= (String) redisService.get(token);
        if(StringUtils.isEmpty(userId)){
            return ResultUtil.success(-1,"请您登陆");
        }
        goodsData.setUserId(userId);
        int num=goodsService.updateGoodsData(goodsData);
        if(num>0){
            return ResultUtil.success(0,"修改商品信息成功");
        }
        return ResultUtil.success(1,"修改商品信息失败");

    }

    @PostMapping(value = "/deleteData")
    public Result deleteGoodsData(HttpServletRequest request, @RequestBody Map<String,List<String>> params){
        String token=request.getHeader("token");
        List<String> id=params.get("id");
        if(id.size()==0){
            return ResultUtil.success(1,"商品id不能为空");
        }
        int num=goodsService.deleteGoodsData(id);
        if (num>0){
            return ResultUtil.success(0,"删除商品成功");
        }
        return ResultUtil.success(1,"删除商品失败");
    }
}
