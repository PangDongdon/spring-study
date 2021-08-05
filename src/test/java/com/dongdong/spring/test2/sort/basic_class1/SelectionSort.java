package com.dongdong.spring.test2.sort.basic_class1;

import com.dongdong.spring.test2.sort.CommonUtils;

/**
 * @author dongDong.pang
 * @date 2021/8/4 16:29
 */
public class SelectionSort {

    private static   void  sort(int[] arr){
        if(arr.length<=1){
            return;
        }
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
                CommonUtils.swapData(arr,i,minIndex);
            }

        }
        CommonUtils.printData(arr);
    }

    public static void main(String[] args) {
        sort(CommonUtils.arr);
    }
}
