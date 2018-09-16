package com.mysheng.office.mapper;

import com.mysheng.office.model.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SellerMapper {
    /**
     * 查询全部商家
     */
    List<Seller>querySellers();
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
     * 根据用户id修改商家信息
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
     * 根据商家id修改商家密码
     * @param sellerId
     * @return
     */
    int updateSellerPassword(@Param("sellerPassword") String sellerPassword, @Param("sellerId") int sellerId);
    /**
     * 根据useId查询旧密码
     * @param sellerId
     * @return
     */
    String selectOldPassword(int sellerId);
    /**
     * 根据手机号登陆
     */
    String selectPassword(String phone);

}
