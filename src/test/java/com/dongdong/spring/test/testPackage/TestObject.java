package com.dongdong.spring.test.testPackage;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Date: 2019/10/23  9:53
 * @Author: dongdong
 */@Data
public class TestObject {
    public String sex;
    public Integer age;
    public static void main(String[] args){
           /* TestObject testObject=new TestObject();
            testObject.setAge(3);
            testObject.setSex("man");*/
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("ss",1);
            map.put("dd",13);
            System.out.println(map);
    }

}
