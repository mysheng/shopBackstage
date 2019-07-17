package com.mysheng.office.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GoodsNorms {

    private String id;
    private String goodsId;
    private String normsName;
    private Integer normsCode;//规格属性纬度一个商品最多两个纬度 eg:颜色和尺寸
    private String normsValue;
    private double originalPrice;
    private double goodsPrice;
    private Integer goodsStock;
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

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getNormsName() {
        return normsName;
    }

    public void setNormsName(String normsName) {
        this.normsName = normsName;
    }

    public Integer getNormsCode() {
        return normsCode;
    }

    public void setNormsCode(Integer normsCode) {
        this.normsCode = normsCode;
    }

    public String getNormsValue() {
        return normsValue;
    }

    public void setNormsValue(String normsValue) {
        this.normsValue = normsValue;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
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
