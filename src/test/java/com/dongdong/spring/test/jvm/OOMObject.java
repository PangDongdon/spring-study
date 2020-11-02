package com.dongdong.spring.test.jvm;

import net.dongliu.commons.Sys;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/10/29  17:34
 * @Author: dongdong
 */
public class OOMObject {
    public  byte[] placeholder=new byte[64* 1024];

    public static  void filHeap(int num) throws InterruptedException{
        List<OOMObject>  list=new ArrayList<>();
        for(int i=0;i<num;i++){
            Thread.sleep(50);
            list.add(new OOMObject());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        filHeap(100);
        System.gc();
    }


}
