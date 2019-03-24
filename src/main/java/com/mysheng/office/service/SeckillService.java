package com.mysheng.office.service;

import com.mysheng.office.model.Seckill;

import java.util.List;

public interface SeckillService {
    List<Seckill> selectIndexSeckill(String date);
}
