package com.dongdong.spring.test.sort2;

import org.junit.Test;

/**
 * 桶排序--计数
 */
public class BucketSort {

    public  void bucketSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
             maxValue= Math.max(arr[i], maxValue);
        }
        int[] bucket=new int[maxValue+1];
        for(int i=0;i<arr.length;i++){
            bucket[arr[i]]++;
        }
        int i=0;
        for(int j=0;j<bucket.length;j++){
            while (bucket[j]-->0){
                arr[i++]=j;
            }
        }

    }

    @Test
    public void test(){
        int[] ss=JavaUtil.s;
        bucketSort(ss);
        JavaUtil.printNum(ss);
    }


}
