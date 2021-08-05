package com.dongdong.spring.test2.sort.basic_class1;

/**
 * @author dongDong.pang
 * @date 2021/8/3 16:15
 * desc:
 */
public class BubbleSort {
   static int[] a={9,2,3,4,6,5};
    //swap two data
    private static int[] swapData(int[] arr,int a,int b){
        arr[a]=arr[a] ^ arr[b];
        arr[b]=arr[a] ^ arr[b];
        arr[a]=arr[a] ^ arr[b];
        return arr;
    }
    //for print data
    private static void printData(int[] arr){
        if(arr.length<=1){
            return;
        }
        for (int a:arr){
            System.out.println(a);
        }
    }
    //for execute sort
    private static  void sort(int[] arr){
        if(arr.length<=1){
            return;
        }
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    swapData(arr,j,j+1);
                }
            }
        }
        printData(arr);
    }


    public static void main(String[] args) {
       sort(a);
    }

}
