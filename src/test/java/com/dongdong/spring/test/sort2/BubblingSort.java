package com.dongdong.spring.test.sort2;

import org.junit.Test;

/**
 * 冒泡排序
 * */
public class BubblingSort {

  @Test
  public  void  test(){
   sort(JavaUtil.s);
  }

  public void sort(int[] arr){
   if(arr==null || arr.length<2){
    return;
   }
   for(int i=arr.length-1;i>0;i--){
     for(int j=0;j<i;j++){
       if(arr[j]>arr[j+1]){
        JavaUtil.swapNum(arr,j,j+1);
       }
     }
   }
  JavaUtil.printNum(arr);
  }

}
