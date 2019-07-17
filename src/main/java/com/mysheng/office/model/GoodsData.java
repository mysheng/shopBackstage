package com.mysheng.office.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GoodsData {

    private String id;
    private  String userId;
    private String goodsName;
    private String goodsPinyin;
    private String goodsNorms;
    private String goodsUnit;
    private String goodsCode;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createDate;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm:ss")
    private Date updateDate;
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

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNorms() {
        return goodsNorms;
    }

    public void setGoodsNorms(String goodsNorms) {
        this.goodsNorms = goodsNorms;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsPinyin() {
        return goodsPinyin;
    }

    public void setGoodsPinyin(String goodsPinyin) {
        this.goodsPinyin = goodsPinyin;
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
