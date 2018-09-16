package com.mysheng.office.controller;


import com.mysheng.office.model.Result;

import com.mysheng.office.util.PushMsg;
import com.mysheng.office.util.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/push")
public class PushMsgController {

    @GetMapping(value = "/pushMsg")
    public Result<String> pushMessage(){

        PushMsg.pushMsgData();

        return ResultUtil.success(0, "推送成功！");
    }


}
