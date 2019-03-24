package com.mysheng.office.mapper;

import com.mysheng.office.model.GoodsImage;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface GoodsImageMapper {

    List<GoodsImage> selectByGoodsId(Integer id);

}
