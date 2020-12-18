package com.dongdong.spring.test.testPackage;


import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/12/7  11:09
 * @Author: dongdong
 */
public class TestEnum {

    public enum  Type{
        UCCESSFUL("0","成功"),FAILURE("1","失败");
        private String code;
        private String  desc;
        Type(String code,String desc){
         this.code=code;
         this.desc=desc;
        }
    }

    @Test
    public void  test(){
        System.out.println(Type.FAILURE.name());
        System.out.println(Type.valueOf("FAILURE"));
        System.out.println("x--x+".replaceAll("-","*"));
    }

}
