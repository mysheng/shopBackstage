package com.mysheng.office.mapper;

import com.mysheng.office.model.Navigation;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface NavigationMapper {

    List<Navigation> selectIndexNavigation();
}
