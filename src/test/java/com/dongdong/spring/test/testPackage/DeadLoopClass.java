package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/11/15  13:44
 * @Author: dongdong
 */

public class DeadLoopClass {
    static{
        if(true){
            System.out.println(Thread.currentThread()+"init DeadLoopClass");
            while(true){

            }
        }
    }
}
