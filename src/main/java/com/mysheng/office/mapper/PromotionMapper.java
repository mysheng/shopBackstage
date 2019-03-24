package com.mysheng.office.mapper;

import com.mysheng.office.model.Promotion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PromotionMapper {
    List<Promotion> selectIndexPromotion(String date);
}
