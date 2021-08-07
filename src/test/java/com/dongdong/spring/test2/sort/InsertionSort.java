package com.dongdong.spring.test2.sort;

/**
 * @Description:
 * @Date: 2021/2/4  14:05
 * @Author: dongdong
 */
public class InsertionSort {

    public static void main(String[] args) {
        test(RequestParam.params);
    }

    private  static  int[] test(int[] arr){
        for(int i=1;i<arr.length;i++){
             int preIndex=i-1;
             int curr=arr[i];
             while(preIndex>=0 && arr[preIndex]>curr){
                 arr[preIndex+1]=arr[preIndex];
                 preIndex-=1;
             }
             arr[preIndex+1]=curr;
        }
        DisplayData.printResult(arr);
       return  arr;
    }
}
