package com.mysheng.office.mapper;

import com.mysheng.office.model.LiveAndShoping;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface LiveAndShopingMapper {
    public List<LiveAndShoping> findAll();
}
