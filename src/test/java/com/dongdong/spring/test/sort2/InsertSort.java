package com.dongdong.spring.test.sort2;

import org.junit.Test;

public class InsertSort {
    @Test
    public  void test(){
        sort(JavaUtil.s);
    }

    public void sort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0 && arr[j]>arr[j+1];j--){
                JavaUtil.swapNum(arr,j,j+1);
            }
        }
        JavaUtil.printNum(arr);
    }
}
