package com.dongdong.spring.test.javaDesignModel4;

import org.junit.Test;

/** 单例模式
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/26  17:20
 */
public class Singleton {

    private  static   Singleton sing;
    public static Singleton getInstance(){
        if(sing==null){
            sing=new Singleton();
        }
        return sing;
    }

    @Test
    public void testSingleModel(){
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }

}
