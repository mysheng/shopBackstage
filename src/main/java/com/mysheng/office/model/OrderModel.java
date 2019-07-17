package com.mysheng.office.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderModel {

    private  String id;
    private  String userId;
    private  String orderId;
    private  String shopId;
    private  String shopName;
    private  double orderAmount;
    private  double payAmount;
    private  double discountAmount;
    private  double payFreight;//运费
    private  int status; //0-未支付 1-支付完成 2已发货 3 已收货 4 待评价 5已完成 -1已关闭  -2 申请退款 -3已退款
    private  boolean isCoupon;
    private  String couponId;
    private  String refundId;
    private  double refundAmount;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date payCreateDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date refundDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    private String comments;
}
