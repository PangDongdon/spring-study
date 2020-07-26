package com.dongdong.spring.test.sort;
/**
 * 插入排序
 *
 * */
public class InsertSort {
    public static void main(String[] args) {
        int temp=0;
        int[] arr={1,2,5,3,4};
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }else {
                    break;
                }
            }
        }
        //outPut result
        for(int ss:arr){
            System.out.println(ss);
        }
    }
}
