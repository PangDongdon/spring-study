package com.dongdong.spring.test.testPackage;


import org.apache.el.util.Validation;
import org.springframework.util.Assert;


import java.util.Optional;

/**
 * @Description: 垃圾回收test
 * @Date: 2020/5/6  18:02
 * @Author: dongdong
 */
public class GCTest {

    public static void main(String[] args) {
      /*  for(int i=0;i<9;i++){
            new GCTest();
            System.gc();
        }*/
        Optional<String> dd= Optional.of("fff");
        //Assert.notNull();
    }

    public void finalize(){
        System.out.println("回收垃圾");
    }
}
