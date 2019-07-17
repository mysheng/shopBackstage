package com.mysheng.office.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品基础信息
 */

public class GoodsMsg implements Serializable {

    private String id;
    private String shopId;
    private String userId;
    private String goodsBrand;
    private String goodsCode;
    private String goodsName;
    private String goodsTitle;
    private String goodsPinyin;
    private Integer goodsState;
    private Integer examineState;
    private double goodsPrice;//基础价格
    private Integer oneCode;
    private Integer twoCode;
    private Integer threeCode;
    private Integer salesVolume;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    @Value("ashdadasdad")
    private String comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsPinyin() {
        return goodsPinyin;
    }

    public void setGoodsPinyin(String goodsPinyin) {
        this.goodsPinyin = goodsPinyin;
    }

    public Integer getGoodsState() {
        return goodsState == null ? 0 : goodsState;
    }

    public void setGoodsState(Integer goodsState) {

        this.goodsState = goodsState == null ? 0 : goodsState;
    }

    public Integer getExamineState() {
        return examineState == null ? 0 : examineState;
    }

    public void setExamineState(Integer examineState) {
        this.examineState = examineState == null ? 0 : examineState;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getOneCode() {
        return oneCode;
    }

    public void setOneCode(Integer oneCode) {
        this.oneCode = oneCode;
    }

    public Integer getTwoCode() {
        return twoCode;
    }

    public void setTwoCode(Integer twoCode) {
        this.twoCode = twoCode;
    }

    public Integer getThreeCode() {
        return threeCode;
    }

    public void setThreeCode(Integer threeCode) {
        this.threeCode = threeCode;
    }

    public Integer getSalesVolume() {

        return salesVolume==null?0:salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {

        this.salesVolume = salesVolume==null?0:salesVolume;
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
