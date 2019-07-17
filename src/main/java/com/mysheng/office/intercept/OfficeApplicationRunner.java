package com.mysheng.office.intercept;

import com.mysheng.office.model.Classify;
import com.mysheng.office.service.ClassifyService;
import com.mysheng.office.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OfficeApplicationRunner implements ApplicationRunner {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ClassifyService classifyService;

    @Autowired
    private  RedisService redisService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        long num=System.currentTimeMillis();
        List<Classify> classifies=classifyService.queryClassify(0);
        redisService.set("classify",classifies);
        long num2=System.currentTimeMillis();
        logger.info(num2-num+"");
    }
}
