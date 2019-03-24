package com.mysheng.office.service;

import com.mysheng.office.model.Promotion;
import java.util.List;

public interface PromotionService {
    List<Promotion> selectIndexPromotion(String date);
}
