package com.mysheng.office.enums;

public enum ResultEnum {
    SYSTEM(-1,"[系统异常]"),
    SUCCESS(1,"成功！"),
    Pw_ERROR(0,"密码错误！")
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
