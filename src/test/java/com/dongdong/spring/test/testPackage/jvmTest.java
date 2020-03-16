package com.dongdong.spring.test.testPackage;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2019/12/9  16:43
 * @Author: dongdong
 */
public class jvmTest {

    public int doubleValue(int i){
        for(int j=0;j<10000;j++);
            return i*2;
    }

    @Test
    public void test(){
        long startTime=System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+"线程开始执行的时间为："+startTime);
        for(int i=0;i<1000000;i++)
        {

        }
        System.out.println(Thread.currentThread().getName()+"线程执行耗时："+(System.currentTimeMillis()-startTime)+"ms");
    }
}
