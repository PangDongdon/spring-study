package com.dongdong.spring.test.testPackage;

import org.apache.poi.ss.formula.functions.T;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @Description:
 * @Date: 2019/11/25  18:29
 * @Author: dongdong
 */
public class exceptionTest {

    public void test1(){
        Object object=null;
        Assert.notNull(object,"必定报错");
    }
    @Test
    public void test2(){
        try{
            test1();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("===============");
            throw e;
        }
        System.out.println("会执行到这里吗");
    }

    @Test
    public void testJsonObject(){
        Object contextHolder=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(contextHolder);
    }
}
