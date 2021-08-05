package com.dongdong.spring.test2.sort;

/**
 * @author dongDong.pang
 * @date 2021/8/3 19:34
 * desc:工具
 */
public class CommonUtils {
    //swap two data
    public static final  int[] arr={36,3,4,1,5,6};
    public static int[] swapData(int[] arr,int a,int b){
        arr[a]=arr[a] ^ arr[b];
        arr[b]=arr[a] ^ arr[b];
        arr[a]=arr[a] ^ arr[b];
        return arr;
    }
    //for print data
    public static void printData(int[] arr){
        if(arr.length<=0){
            return;
        }
        for (int a:arr){
            System.out.println(a);
        }
    }

}
