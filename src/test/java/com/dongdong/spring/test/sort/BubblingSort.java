package com.dongdong.spring.test.sort;

/**
 * 冒泡排序
 *
 * */
public class BubblingSort {
    public static void main(String[] args) {
        //定义一个中间变量
        int temp=0;
        //定义一个整数数组
        int[] arr={2,333,444,1,4,5,6,899};
        for(int i=0;i<arr.length-1;i++){
            for (int j=arr.length-1;j>i;j--){
                //后一个比前一小，则交换
                if(arr[j]<arr[j-1]){
                    temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
            }
        }
        //outPut result
        for(int ss:arr){
            System.out.println(ss);
        }

    }
}
