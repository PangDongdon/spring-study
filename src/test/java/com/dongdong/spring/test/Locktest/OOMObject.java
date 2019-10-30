package com.dongdong.spring.test.Locktest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/10/25  17:37
 * @Author: dongdong
 */
   public class OOMObject {
         public byte[] placeholder=new byte[64*1024];
       public static void fillHeap(int num) throws InterruptedException{
           List<OOMObject> list=new ArrayList<OOMObject>();
           for(int i=0;i<num;i++){
              Thread.sleep(50);
              list.add(new OOMObject());
           }
       }

       public static void main(String[] args){
           try {
               fillHeap(1000);
               System.gc();
           }catch (Exception e){
               e.fillInStackTrace();
           }
       }
   }


