package com.mysheng.office.exception;

import com.mysheng.office.enums.ResultEnum;

/**
 * 通用异常处理
 */
public class CommentException extends RuntimeException {
    private Integer code;
    public CommentException(ResultEnum re){
        super(re.getMessage());
        this.code=re.getCode();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
