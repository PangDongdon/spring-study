package com.dongdong.spring.test.testPackage;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2019/11/22  17:25
 * @Author: dongdong
 */
public class textException {

    public void test1() throws Exception {

        if(2!=3){
            throw  new Exception("服务调用异常");
        }

    }

    @Test
    public void test2(){
        try {
            test1();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testString(){
        String s="everyday";
        System.out.println(String.format("%s多思考,多学习",s));
    }


}
