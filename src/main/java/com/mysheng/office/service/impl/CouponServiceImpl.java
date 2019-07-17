package com.mysheng.office.service.impl;

import com.mysheng.office.enums.ResultError;
import com.mysheng.office.exception.CustomException;
import com.mysheng.office.mapper.CouponMapper;
import com.mysheng.office.model.CouponModel;
import com.mysheng.office.service.CouponService;
import com.mysheng.office.util.PinYinUtil;
import com.mysheng.office.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CouponServiceImpl implements CouponService {
    @Autowired
    private CouponMapper couponMapper;

    @Override
    public List<CouponModel> queryCoupon(Map<String ,Object> param) {
        return couponMapper.queryCoupon(param);
    }

    @Override
    public CouponModel queryCouponById(String CouponId) {
        return couponMapper.queryCouponById(CouponId);
    }

    @Override
    public int insertCoupon(CouponModel couponModel) {
        couponModel.setId(UUIDUtil.getUUID());
        couponModel.setLimitName("满"+Math.floor(couponModel.getLimitAmount())+"减"+Math.floor(couponModel.getCouponAmount()));
        return couponMapper.insertCoupon(couponModel);
    }

    @Override
    public int updateCoupon(CouponModel couponModel) {
        couponModel.setLimitName("满"+Math.floor(couponModel.getLimitAmount())+"减"+Math.floor(couponModel.getCouponAmount()));
        return couponMapper.updateCoupon(couponModel);
    }

    @Override
    public int deleteCoupon(String CouponId) {
        return couponMapper.deleteCoupon(CouponId);
    }

    @Override
    public List<CouponModel> queryUserCoupons(String userId) {
        return couponMapper.queryUserCoupons(userId);
    }

    @Override
    public List<CouponModel> queryCouponsByStatus(String userId, int status) {
        return couponMapper.queryCouponsByStatus(userId,status);
    }

    @Override
    public int userCollarCoupons(String userId,String couponId) {
        List<CouponModel> couponModels=couponMapper.queryUserCouponsByCouponId(userId,couponId);
        return 0;
    }

    @Override
    public int deleteUserCoupon(String couponId) {
        return couponMapper.deleteUserCoupon(couponId);
    }
}
