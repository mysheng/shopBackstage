package com.mysheng.office.mapper;

import com.mysheng.office.model.Findshop;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FindshopMapper {
    List<Findshop> selectIndexFindshop(String date);
}
