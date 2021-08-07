package com.dongdong.spring.test2.sort;

/**
 * @Description:
 * @Date: 2021/2/4  11:43
 * @Author: dongdong
 */
public class SelectionSort {
    public static void main(String[] args) {
           test(RequestParam.params);
    }

    public  static int[] test(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int minindex=i;
              for(int j=i+1;j<arr.length;j++){
                  if(arr[minindex]>arr[j]){
                      minindex=j;
                  }
              }
              if(minindex!=i){
                  int temp=arr[minindex];
                  arr[minindex]=arr[i];
                  arr[i]=temp;
              }
        }
        DisplayData.printResult(arr);
        return  arr;
    }
}
