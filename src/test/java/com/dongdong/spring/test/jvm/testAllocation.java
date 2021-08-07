package com.dongdong.spring.test.jvm;

import com.dongdong.spring.Application;
import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/10/28  17:20
 * @Author: dongdong
 */
public class testAllocation {

    private static final int  _1mb=1024*1024;

    public  enum  Appid{
        ASS("22");
        private  String id;
        Appid(String id){
            this.id=id;
        }
        public String getName(){
            return  this.name();
        }

    }
    @Test
    public void test(){
        System.out.println(Appid.ASS.getName());
    }

    public static void main(String[] args) {
        byte[] allocation1,allocaation2,allocation3,allocation4;
        allocation1=new byte[2*_1mb];
        allocaation2=new byte[2*_1mb];
        allocation3=new byte[2*_1mb];
        allocation4=new byte[4*_1mb];
    }
}
