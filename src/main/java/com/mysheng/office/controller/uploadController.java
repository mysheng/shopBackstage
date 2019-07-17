package com.mysheng.office.controller;

import com.mysheng.office.model.Result;
import com.mysheng.office.service.impl.UploadImage;
import com.mysheng.office.util.ResultUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class uploadController {
    private final static Logger logger= LoggerFactory.getLogger(uploadController.class);

    @Autowired
    private UploadImage uploadImage;

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "bootstrapTable/left";
    }
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String goToIndex() {

        return "bootstrapTable/index";
    }
    //处理文件上传
    @RequestMapping(value="/uploadimg", method = RequestMethod.POST)
    public @ResponseBody Result uploadImg(@RequestParam("goodsId") int goodsId,@RequestParam("file") MultipartFile[] file, HttpServletRequest request) {

        if (file.length<1) {
            return ResultUtil.error(1,"文件为空！");
        }

//        boolean isImage=uploadImage.imageUpload(goodsId,file);
//        if(isImage){
//            ResultUtil.error(0,"文件上传成功");
//        }

        return ResultUtil.error(1,"文件上传失败");
    }

}
