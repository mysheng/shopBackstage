package com.mysheng.office.util;

import com.mysheng.office.model.Result;

public class ResultUtil {
    public static Result success(Integer code,String message,Object object){
        Result result=new Result(code,message,object);
        return result;
    }
    public static Result success(Integer code,String message){
        return success(code,message,null);
    }
    public static Result error(Integer code,String msg){
        Result result=new Result(code,msg,null);
        return result;
    }
}
