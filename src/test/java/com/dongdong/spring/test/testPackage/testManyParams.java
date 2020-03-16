package com.dongdong.spring.test.testPackage;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/1/2  11:09
 * @Author: dongdong
 */
public class testManyParams {



    public void manyParams(String... args){
        for(String value: args){
            System.out.println(value);
        }
    }

    @Test
    public void test(){
        manyParams("must keep","stay hungry","stay foolish");
    }
}
