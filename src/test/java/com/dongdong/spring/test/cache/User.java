package com.dongdong.spring.test.cache;

import lombok.Data;
import org.springframework.cache.annotation.Cacheable;

/**
 * @Description:
 * @Date: 2019/11/27  14:00
 * @Author: dongdong
 */
@Data
public class User {
    private String nme;
    private int age;
    private String sex;

     @Cacheable(cacheNames = "cacheManeger",key = "'USER:'+#id",unless = "#result==null")
    public User getUser(int id){
        System.out.println(id);
        return null;
    }

}
