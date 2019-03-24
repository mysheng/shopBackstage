package com.mysheng.office.service;

import com.mysheng.office.model.Findshop;
import java.util.List;

public interface FindshopService {
    List<Findshop> selectIndexFindshop(String date);
}
