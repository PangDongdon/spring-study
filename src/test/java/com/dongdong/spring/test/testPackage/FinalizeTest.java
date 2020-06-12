package com.dongdong.spring.test.testPackage;

import com.dongdong.spring.test.Locktest.SynAddRunable;

/**
 * @Description:
 * @Date: 2020/5/7  11:01
 * @Author: dongdong
 */
public class FinalizeTest {
    private  static  FinalizeTest ft=null;

    public void info(){
        System.out.println("测试清理资源的finalize()方法");
    }
    public static void main(String[] args) {
       new FinalizeTest();
        System.gc();
        //验证是否调用finalize() 方法
        Runtime.getRuntime().runFinalization();
        ft.info();
    }

    public  void finalize(){
        ft=this;
    }
}
