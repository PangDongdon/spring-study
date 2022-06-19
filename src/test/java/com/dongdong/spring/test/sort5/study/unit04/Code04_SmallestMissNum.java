package com.dongdong.spring.test.sort5.study.unit04;
/**
 *  求数组中未出现的正整数，时间复杂度O(n),空间复杂度O(1)
 */
public class Code04_SmallestMissNum {

    public static  int missNum(int[] arr){
        if(arr==null || arr.length<1){
            return -1;
        }
        int L=0;
        int R=arr.length;
        while(L<R){
            if(arr[L]==L+1){
                L++;
            }else  if(arr[L]<=L ||arr[L]>R || arr[arr[L]-1]==arr[L]){
                swap(arr,L,--R);
            }else{
                swap(arr,arr[L]-1,L);
            }
        }
        return L+1;
    }
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    public static void main(String[] args) {
        int[] arr = { -1, 0, 2, 1, 3, 5 };
        System.out.println(missNum(arr));
    }
}
