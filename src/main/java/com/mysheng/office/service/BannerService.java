package com.mysheng.office.service;

import com.mysheng.office.model.Banner;
import java.util.List;

public interface BannerService {
    List<Banner> selectIndexBanner(String date);
}
