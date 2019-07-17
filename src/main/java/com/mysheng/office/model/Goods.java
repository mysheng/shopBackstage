package com.mysheng.office.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Goods implements Serializable {
    private String id;
    private String goodsNum;
    private String goodsName;
    private String goodsPinyin;
    private String shopId;
    private String typeCode;
    private String typeName;
    private String goodsNorms;
    private String goodsPrice;
    private String oldPrice;
    private String couponId;
    private boolean coupon;
    private boolean reduce;
    private double reduceAmount;
    private double reduceLimit;
    private Integer status;
    private Integer stock;
    private Integer volume;
    private String goodsUnit;
    private String createUserId;
    private String updateUserId;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    private String comments;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsPinyin() {
        return goodsPinyin;
    }

    public void setGoodsPinyin(String goodsPinyin) {
        this.goodsPinyin = goodsPinyin;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }



    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }


    public boolean isCoupon() {
        return coupon;
    }

    public void setCoupon(boolean coupon) {
        this.coupon = coupon;
    }

    public boolean isReduce() {
        return reduce;
    }

    public void setReduce(boolean reduce) {
        this.reduce = reduce;
    }

    public double getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(double reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public double getReduceLimit() {
        return reduceLimit;
    }

    public void setReduceLimit(double reduceLimit) {
        this.reduceLimit = reduceLimit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public String getGoodsNorms() {
        return goodsNorms;
    }

    public void setGoodsNorms(String goodsNorms) {
        this.goodsNorms = goodsNorms;
    }

    public String getCreateUserId() {
        return createUserId;
    }


    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

