package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.NavigationMapper;
import com.mysheng.office.model.Banner;
import com.mysheng.office.model.Navigation;
import com.mysheng.office.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Autowired
    private NavigationMapper navigationMapper;
    @Override
    public List<Navigation> selectIndexNavigation() {
        return navigationMapper.selectIndexNavigation();
    }
}
