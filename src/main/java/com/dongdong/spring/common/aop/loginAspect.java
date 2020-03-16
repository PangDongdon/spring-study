package com.dongdong.spring.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.StringUtils;

/**
 * @Description:
 * @Date: 2019/11/28  10:53
 * @Author: dongdong
 */
public class loginAspect {
    @Pointcut("@annotation(com.dongdong.spring.common.aop.Auth)")
    public void access(){

    }
    @Before("access()")
    public void before(){
        System.out.println("开始验证用户是否登录.....");
    }

    @Around("@annotation(auth)")
    public Object aound(ProceedingJoinPoint proceedingJoinPoint,Auth auth){
        //获得注解中的值
        System.out.println("获得注解内容："+auth.desc());
        try{

            boolean flag=true;
            if(false==true){
                return "登录成功";
            }else{
                return "登录失败";
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
