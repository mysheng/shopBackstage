package com.mysheng.office.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysheng.office.model.ChatModel;
import com.mysheng.office.model.Result;
import com.mysheng.office.service.MessageService;
import com.mysheng.office.util.PageBean;
import com.mysheng.office.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {
    @Autowired
    private MessageService msgService;
    @GetMapping(value = "/findsMsg")
    public Result<PageBean<ChatModel>> findAllGoods(@RequestParam("currIndex") Integer currIndex, @RequestParam("pageSize") Integer pageSize){
        PageHelper.startPage(currIndex, pageSize);
        PageHelper.orderBy("mes_date desc");
        List<ChatModel>list=msgService.queryChatModel();
        PageInfo<ChatModel> pageInfo = new PageInfo<>(list);
        if(list.size()>0){
            return ResultUtil.success(1,"查询成功！",pageInfo);
        }
        return ResultUtil.success(0, "没有查询到数据");
    }


}
