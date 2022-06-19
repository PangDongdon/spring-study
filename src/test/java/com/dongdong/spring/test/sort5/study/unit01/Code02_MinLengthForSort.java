package com.dongdong.spring.test.sort5.study.unit01;

public class Code02_MinLengthForSort {

    public static int getMinLength(int[] arr) {
        if(arr==null || arr.length<2){
            return  0;
        }
        int min=arr[arr.length-1];
        int minIndex=-1;
        for(int i=arr.length-2;i>-1;i--){
            if(min<arr[i]){
                minIndex=i;
            }else{
                min=Math.min(min,arr[i]);
            }
        }
        if(minIndex==-1){
            return 0;
        }

        int maxIndex=-1;
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max>arr[i]){
                maxIndex=i;
            }else{
                max=Math.max(max,arr[i]);
            }
        }
        return  maxIndex-minIndex+1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
        System.out.println(getMinLength(arr));
    }
}
