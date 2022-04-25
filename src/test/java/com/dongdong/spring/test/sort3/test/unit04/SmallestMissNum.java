package com.dongdong.spring.test.sort3.test.unit04;

public class SmallestMissNum {

    public  static  int missNum(int[] arr){
        if(arr==null){
            return 0;
        }
        int l=0;
        int r=arr.length;
        while(l<r){
            if(arr[l]==l+1){
                l++;
            }else if(arr[l]<=l || arr[l]>r || arr[arr[l]-1]==arr[l]){
                arr[l]=arr[--r];
            }else {
                swap(arr,l,arr[l]-1);
            }

        }
        return r+1;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 2, 1, 3, 5 };
        System.out.println(missNum(arr));

    }
}
