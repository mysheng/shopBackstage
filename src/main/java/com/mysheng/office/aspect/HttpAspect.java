package com.mysheng.office.aspect;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.mysheng.office.controller.*.*(..))")
    public void log(){
        String str="测试";



    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attr= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest=attr.getRequest();
        logger.info("url={}",httpServletRequest.getRequestURL());
        logger.info("method={}",httpServletRequest.getMethod());
        logger.info("ip={}",httpServletRequest.getRemoteAddr());
        logger.info("class_method",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());


    }
    @After("log()")
    public void doAfter(){
        logger.info("22222222");
    }
    @AfterReturning(returning = "object",pointcut="log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object);
    }
}
