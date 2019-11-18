package com.dongdong.spring.service;

import org.junit.Test;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Description:
 * @Date: 2019/11/1  11:30
 * @Author: dongdong
 */
public class HttpTest {

    /**
     * 不带参的get请求
     * */
    @Test
    public void restTemplateGetTest(){
        RestTemplate restTemplate=new RestTemplate();
        Notice notice=restTemplate.getForObject("https://www.taobao.com/",Notice.class);
        System.out.println(notice);
    }


    @Test
     public void  getTest(){
        System.out.println(getCount("dd"));
    }


    @Test
    public void  getMultiValue(){

    }

    public <T> T  getCount(T s){
        return s;
    }

}
