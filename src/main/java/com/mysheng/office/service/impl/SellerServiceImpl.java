package com.mysheng.office.service.impl;

import com.mysheng.office.enums.ResultEnum;
import com.mysheng.office.exception.CommentException;
import com.mysheng.office.mapper.SellerMapper;
import com.mysheng.office.model.Seller;
import com.mysheng.office.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerMapper sellerMapper;
    @Override
    public List<Seller> querySeller() {
        return sellerMapper.querySellers();
    }

    @Override
    public Seller querySellerById(int sellerId) {
        return sellerMapper.querySellerById(sellerId);
    }

    @Override
    public int insertSeller(Seller seller) {
        String sellerNum=  System.currentTimeMillis()+"";
        seller.setSellerNum(sellerNum);
        return sellerMapper.insertSeller(seller);
    }

    @Override
    public int updateSeller(Seller seller) {
        return sellerMapper.updateSeller(seller);
    }

    @Override
    public int deleteSeller(int sellerId) {
        return sellerMapper.deleteSeller(sellerId);
    }

    @Override
    public int updateSellerPassword(String oldPassword, String sellerPassword, int sellerId) {
        String oldPw=sellerMapper.selectOldPassword(sellerId);
        if(!oldPassword.equals(oldPw)){
            throw new CommentException(ResultEnum.Pw_ERROR);
        }
        int num=sellerMapper.updateSellerPassword(sellerPassword,sellerId);

        return num;
    }

    @Override
    public int loginInfo(String phone, String password) {
        String pw=sellerMapper.selectPassword(phone);
        if (password.equals(pw)){
            return 1;
        }
        return 0;
    }
}
