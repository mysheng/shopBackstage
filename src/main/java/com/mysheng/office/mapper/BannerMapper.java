package com.mysheng.office.mapper;
import com.mysheng.office.model.BannerModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface BannerMapper {

    List<BannerModel> queryBanner(Date date);

}
