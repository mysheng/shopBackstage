package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.SeckillMapper;
import com.mysheng.office.model.Seckill;
import com.mysheng.office.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private SeckillMapper seckillMapper;

    @Override
    public List<Seckill> selectIndexSeckill(String date) {
        return seckillMapper.selectIndexSeckill(date);
    }
}
