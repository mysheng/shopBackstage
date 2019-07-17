package com.mysheng.office.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class UserVip {
    private String id;
    private String userId;
    private String vipNo;
    private String vipLevel;
    private String payType;
    private int vipStatus;
    private int payStatus;
    private double payAmount;
    private double orderAmount;
    private int isCoupon;
    private String couponId;
    private String discountAmount;
    private String refundId;
    private double refundAmount;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date vipPayDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date vipOverdueDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date refundDate;
    private String comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVipNo() {
        return vipNo;
    }

    public void setVipNo(String vipNo) {
        this.vipNo = vipNo;
    }

    public String getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(String vipLevel) {
        this.vipLevel = vipLevel;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public int getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(int vipStatus) {
        this.vipStatus = vipStatus;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getIsCoupon() {
        return isCoupon;
    }

    public void setIsCoupon(int isCoupon) {
        this.isCoupon = isCoupon;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Date getVipPayDate() {
        return vipPayDate;
    }

    public void setVipPayDate(Date vipPayDate) {
        this.vipPayDate = vipPayDate;
    }

    public Date getVipOverdueDate() {
        return vipOverdueDate;
    }

    public void setVipOverdueDate(Date vipOverdueDate) {
        this.vipOverdueDate = vipOverdueDate;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
