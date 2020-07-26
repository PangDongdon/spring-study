package com.dongdong.spring.test.sort;
/**
 * 希尔排序
 *
 * */
public class shellSort {

    public static void main(String[] args) {
        int[] arr={1,2,5,3};
         int temp=0;
         int incre=arr.length;

         while(true){
             incre=incre/2;
             for(int k=0;k<incre;k++){//根据增量分为若干子序列
                 for(int i=k+incre;i<arr.length;i+=incre){
                     for(int j=i;j>k;j-=incre) {
                         if (arr[j] < arr[j - incre]) {
                             temp = arr[j - incre];
                             arr[j - incre] = arr[j];
                             arr[j] = temp;
                         } else {
                             break;
                         }
                     }
                 }
             }
         }
    }
}
