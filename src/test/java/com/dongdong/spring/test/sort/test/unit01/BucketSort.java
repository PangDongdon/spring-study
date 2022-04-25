package com.dongdong.spring.test.sort.test.unit01;

import com.dongdong.spring.test.region.Util;
import com.dongdong.spring.test.sort.test.util.Utils;

public class BucketSort {

    public static void   sort(int[] arr){
        if(arr==null){
            return;
        }
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            min=Math.min(arr[i],min);
            max=Math.max(arr[i],max);
        }
        int[] bucket=new int[max-min+1];
        for(int i=0;i<arr.length;i++){
            bucket[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<bucket.length;i++){
            while(bucket[i]-->0){
                arr[j++]=i;
            }
        }
        Utils.printArr(arr);
    }

    public static void main(String[] args) {
        sort(Utils.arr);
    }
}
