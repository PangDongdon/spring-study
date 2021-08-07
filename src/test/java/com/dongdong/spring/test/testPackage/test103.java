package com.dongdong.spring.test.testPackage;

import net.dongliu.commons.Sys;
import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/11/3  13:58
 * @Author: dongdong
 */
public class test103 {

    public int returnValue(){
        int x;
        try{
            x=1;
            return  x;
        }catch(Exception e){
            x=2;
            return  x;
        }finally {
            x=3;
            System.out.println(x);
        }
    }

    @Test
    public  void test(){
        int i=returnValue();
        System.out.println(i);
    }
}
