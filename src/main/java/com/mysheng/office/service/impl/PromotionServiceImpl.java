package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.PromotionMapper;
import com.mysheng.office.model.Promotion;
import com.mysheng.office.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionMapper promotionMapper;

    @Override
    public List<Promotion> selectIndexPromotion(String date) {
        return promotionMapper.selectIndexPromotion(date);
    }
}
