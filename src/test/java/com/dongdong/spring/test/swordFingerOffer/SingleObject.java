package com.dongdong.spring.test.swordFingerOffer;

/**
 * @Description:  饿汉式单例
 * @Date: 2020/7/27  16:26
 * @Author: dongdong
 */
public class SingleObject {

    private static  final  SingleObject singleObject=new SingleObject();

    private  SingleObject(){

    }
    public  static  SingleObject getInstance(){
        return  singleObject;
    }
}
