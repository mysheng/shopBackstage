package com.mysheng.office.service.impl;

import com.mysheng.office.mapper.ClassifyMapper;
import com.mysheng.office.model.Classify;
import com.mysheng.office.model.ClassifyModel;
import com.mysheng.office.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService{
    @Autowired
    private ClassifyMapper mapper;
    @Override
    public List<Classify> queryClassify(int code) {
        List<Classify> classifies=mapper.queryClassify(code);
        for(int i=0;i<classifies.size();i++){
            Classify classify=classifies.get(i);
            List<Classify> classifies1=mapper.queryClassify(classify.getValue());
            for (int j=0;j<classifies1.size();j++){
                Classify classify1=classifies1.get(j);
                List<Classify> classifies2=mapper.queryClassify(classify1.getValue());
                classify1.setChildren(classifies2);
                //classify.getChildren().get(i).setChildren(classifies2);
            }
            classify.setChildren(classifies1);

        }

        return classifies;
    }

    @Override
    public int insertClassify(ClassifyModel model) {
        return mapper.insertClassify(model);
    }

    @Override
    public int updateClassify(ClassifyModel model) {
        return mapper.updateClassify(model);
    }

    @Override
    public int deleteClassify(Integer id) {
        return mapper.deleteClassify(id);
    }
}
