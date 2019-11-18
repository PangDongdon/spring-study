package com.dongdong.spring.test.testPackage;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @Description:
 * @Date: 2019/10/16  19:22
 * @Author: dongdong
 */
public class TestJVM {


    static class ddd{

    }
    @Test
    public void testJVM(){
       List<ddd> list= Lists.newArrayList();
       while(true){
           list.add(new ddd());
           System.out.println(list);
       }

    }

    public static void main(String[] args){
        byte[] placeholder=new byte[64*1024*1024];
        System.gc();
    }
}
