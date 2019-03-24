package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.FindshopMapper;
import com.mysheng.office.model.Findshop;
import com.mysheng.office.service.FindshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindshopServiceImpl implements FindshopService {

    @Autowired
    private FindshopMapper findshopMapper;

    @Override
    public List<Findshop> selectIndexFindshop(String date) {
        return findshopMapper.selectIndexFindshop(date);
    }
}
