package com.mysheng.office.model;

import java.util.List;

public class ShopCarModel {
    private  String shopId;
    private  String telephone;
    private String shopName;
    private boolean shopSelected;
    private List<CarGoodsModel> carGoodsModels;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public boolean isShopSelected() {
        return shopSelected;
    }

    public void setShopSelected(boolean shopSelected) {
        this.shopSelected = shopSelected;
    }

    public List<CarGoodsModel> getCarGoodsModel() {
        return carGoodsModels;
    }

    public void setCarGoodsModel(List<CarGoodsModel> carGoodsModels) {
        this.carGoodsModels = carGoodsModels;
    }
}
