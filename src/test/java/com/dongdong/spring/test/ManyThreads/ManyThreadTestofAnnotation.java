package com.dongdong.spring.test.ManyThreads;

import net.dongliu.commons.Sys;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/7/7  9:39
 * @Author: dongdong
 */
public class ManyThreadTestofAnnotation {
    private  int a=0;
    @Rule
    public ContiPerfRule contiPerfRule=new ContiPerfRule();
    @Test
    @PerfTest(invocations = 10,threads = 10)
    public void test(){
      //for(int i=0;i<10;i++){
          String name=Thread.currentThread().getName();
          System.out.println(name+"---"+ ++a);

     // }
    }
}
