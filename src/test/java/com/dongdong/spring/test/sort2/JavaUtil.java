package com.dongdong.spring.test.sort2;

public class JavaUtil {

    public static  int[] s={5,2,6,7,8,88,9,0,4};

    //打印每个数据
    public static void printNum(int arr[]){
        if(arr==null || arr.length<2){
            return;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"**");
        }
    }
    //交换数据
    public static void swapNum(int[] arr,int m,int n){
        int temp=arr[m];
        arr[m]=arr[n];
        arr[n]=temp;
    }
}
