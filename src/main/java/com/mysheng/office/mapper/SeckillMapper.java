package com.mysheng.office.mapper;

import com.mysheng.office.model.Seckill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeckillMapper {
    List<Seckill> selectIndexSeckill(String date);
}
