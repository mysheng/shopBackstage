package com.mysheng.office.handle;

import com.mysheng.office.exception.CommentException;
import com.mysheng.office.model.Result;
import com.mysheng.office.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */

public class ExceptionHandle {
    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionDispose(Exception e){

        if(e instanceof CommentException){
            CommentException userException= (CommentException) e;
            return ResultUtil.error(userException.getCode(),e.getMessage());
        }else{
            logger.info("[系统异常]={}",e);
            return ResultUtil.error(-1,"系统异常");
        }

    }
}
