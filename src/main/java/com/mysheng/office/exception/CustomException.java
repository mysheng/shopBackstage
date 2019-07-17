package com.mysheng.office.exception;

import com.mysheng.office.enums.ResultError;

public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private  ResultError resultError;
    public CustomException(ResultError re){
        super(re.getMessage());
        this.resultError=re;
    }

    public ResultError getResultError() {
        return resultError;
    }

    public void setResultError(ResultError resultError) {
        this.resultError = resultError;
    }
}
