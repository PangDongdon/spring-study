package com.dongdong.spring.test.sort2;

import org.junit.Test;

public class SelectSort {
   @Test
   public void test(){
       sort(JavaUtil.s);
   }

    public void sort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                minIndex=arr[minIndex]>arr[j] ?j:minIndex;
            }
            JavaUtil.swapNum(arr,i,minIndex);
        }
        JavaUtil.printNum(arr);
    }
}
