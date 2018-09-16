package com.mysheng.office.service;

import com.mysheng.office.model.Seller;

import java.util.List;

public interface SellerService {
    /**
     * 查询全部用户
     * @return
     */
    List<Seller> querySeller();

    /**
     * 根据用户id查询用户
     * @param sellerId
     * @return
     */
    Seller querySellerById(int sellerId);

    /**
     * 新增用户
     * @param seller
     * @return
     */
    int insertSeller(Seller seller);

    /**
     * 根据用户id修改用户信息
     * @param seller
     * @return
     */
    int updateSeller(Seller seller);

    /**
     * 根据用户id删除用户
     * @param sellerId
     * @return
     */
    int deleteSeller(int sellerId);
    /**
     * 根据useId查询旧密码
     * @param sellerId
     * @return
     */

    int updateSellerPassword(String oldPassword, String sellerPassword, int sellerId);

    /**
     * 登陆接口
     * @param phone
     * @param password
     * @return
     */
    int loginInfo(String phone, String password);

}
