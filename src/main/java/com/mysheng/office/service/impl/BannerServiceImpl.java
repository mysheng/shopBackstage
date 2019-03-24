package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.BannerMapper;
import com.mysheng.office.model.Banner;
import com.mysheng.office.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<Banner> selectIndexBanner(String date) {
        return bannerMapper.selectIndexBanner(date);
    }
}
