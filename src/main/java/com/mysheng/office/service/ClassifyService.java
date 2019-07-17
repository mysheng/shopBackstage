package com.mysheng.office.service;

import com.mysheng.office.model.Classify;
import com.mysheng.office.model.ClassifyModel;

import java.util.List;

public interface ClassifyService {

    /**
     * 更具父id查询分类
     * @return
     */
    List<Classify> queryClassify(int code);

    /**
     * 新增用户
     * @param model
     * @return
     */
    int insertClassify(ClassifyModel model);

    /**
     * 根据用户id修改用户信息
     * @param model
     * @return
     */
    int updateClassify(ClassifyModel model);
    /**
     * 根据用户id删除用户
     * @param id
     * @return
     */
    int deleteClassify(Integer id);
}
