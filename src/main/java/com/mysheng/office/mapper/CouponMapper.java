package com.mysheng.office.mapper;

import com.mysheng.office.model.CouponModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CouponMapper {
    /**
     * 查询全部优惠券
     */
    List<CouponModel>queryCoupon(Map<String,Object> param);
    /**
     * 根据优惠券id查询优惠券
     * @param CouponId
     * @return
     */
    CouponModel queryCouponById(String CouponId);

    /**
     * 新增优惠券
     * @param CouponModel
     * @return
     */
    int insertCoupon(CouponModel CouponModel);

    /**
     * 根据优惠券id修改优惠券信息
     * @param CouponModel
     * @return
     */
    int updateCoupon(CouponModel CouponModel);

    /**
     * 修改优惠券的数量
     * @param param
     * @return
     */

    int updateCouponCount(Map<String,Object> param);

    /**
     * 根据优惠券id删除优惠券
     * @param CouponId
     * @return
     */
    int deleteCoupon(String CouponId);

    /**
     * 查询用户已领取的优惠券
     * @return
     */
    List<CouponModel> queryUserCoupons(String userId);
    /**
     * 按couponId用户已领取的优惠券
     * @return
     */
    List<CouponModel> queryUserCouponsByCouponId(@Param("userId") String userId,@Param("couponId") String couponId);

    /**
     *
     * @param userId
     * @return
     */
    List<CouponModel> queryCouponsByStatus(@Param("userId") String userId,@Param("status") int status);
    /**
     * 领取优惠券
     * @return
     */
    int userCollarCoupons(CouponModel couponModel);

    /**
     * 根据优惠券id删除已领取优惠券
     * @param CouponId
     * @return
     */
    int deleteUserCoupon(String CouponId);

}
