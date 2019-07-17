package com.mysheng.office.service;

import com.mysheng.office.model.BannerModel;

import java.util.Date;
import java.util.List;

public interface BannerService {
    List<BannerModel> queryBanner(Date date);
}
