package com.dongdong.spring.test2.sort;


/**
 * @Description:
 * @Date: 2021/2/4  14:32
 * @Author: dongdong
 */
public class ShellSort {

    public static void main(String[] args) {
       test(RequestParam.params);
    }

    private static  int[] test(int[] arr){
        int n=arr.length;
        int gap=n/2;
        while(gap>0){
            for(int i=gap;i<n;i++){
                int curr=arr[i];
                int preIndex=i-gap;
                while (preIndex>=0 && arr[preIndex]>curr){
                    arr[preIndex+gap]=arr[preIndex];
                    preIndex-=gap;
                }
                 arr[preIndex+gap]=curr;
            }
            gap=gap/2;
        }
        DisplayData.printResult(arr);
        return arr;
    }
}
