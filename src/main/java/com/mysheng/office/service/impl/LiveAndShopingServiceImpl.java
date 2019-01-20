package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.LiveAndShopingMapper;
import com.mysheng.office.model.LiveAndShoping;
import com.mysheng.office.service.LiveAndShopingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveAndShopingServiceImpl implements LiveAndShopingService {

    @Autowired
    private LiveAndShopingMapper liveAndShopingMapper;

    @Override
    public List<LiveAndShoping> findAll() {
        return liveAndShopingMapper.findAll();
    }
}
