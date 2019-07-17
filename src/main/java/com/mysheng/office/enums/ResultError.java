package com.mysheng.office.enums;

public enum ResultError {
    SYSTEM(-1,"[系统异常]"),
    Runtime(1,"运行出错异常"),
    ClassCast(2,"类型转换异常"),
    NullPointer(3,"空指针异常"),
    IO(4,"IO异常"),
    NoSuchMethod(5,"未知方法"),
    IndexOutOfBounds(6,"数组越界异常"),
    MissingServletRequest(8,"400"),
    NotSupported(9,"405"),
    TypeNotAcceptable(10,"406"),
    ConversionNotSupported(11,"500"),
    StackOverflow(12,"栈溢出"),
    Unknown(13,"未知错误"),
    Pw_ERROR(102,"手机号或密码错误！"),
    COUPON_ERROR(103,"该优惠券您已领取"),
    LIMIT_COUNT(1110,"访问超限,一分钟之后再试"),
    LOGIN_INFO(401,"您未登陆"),
    LOGIN_INFO_OUT(402,"用户信息已过期")
    ;
    private Integer code;
    private String message;

    ResultError(Integer code, String message) {
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
