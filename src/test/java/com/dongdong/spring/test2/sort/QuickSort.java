package com.dongdong.spring.test2.sort;

import com.dongdong.spring.util.ReadExcel;

/**
 * @Description:
 * @Date: 2021/2/4  17:09
 * @Author: dongdong
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr=test2(RequestParam.params,0,4);
        DisplayData.printResult(arr);
    }

    private static int Partition(int[] arr,int left,int right ){
        if(left==right){
            return  left;
        }
        //random pivot
        int  pivot=(int)(left+Math.random()*(right-left+1));
        swap(arr,pivot,right);
        int small_idx=left;
        for(int i=small_idx;i<right;i++){
            if(arr[i]<arr[right]){
                swap(arr,i,small_idx);
                small_idx++;
                small_idx++;
            }
        }
        swap(arr,small_idx,right);
        return small_idx;
    }



    int[] test(int[] param,int left,int right){
       if(left<right){
         int pivotIndex=Partition(param,left,right);
         //sort(param,left,pivotIndex-1);
        // sort(param,pivotIndex+1,right);
       }
        return param;
    }

    private static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }

    private  static int[] test2(int[] arr,int start,int end){
        if(start<end){
            //选数组中的首数字作为基数
            int stand=arr[start];
            int  low=start;
            int  high=end;
            while(low<high){
                while(low<high && arr[high]>=stand){
                    high--;
                }
                arr[low]=arr[high];
                while (low<high && arr[low]<=stand){
                   low++;
                }
                arr[high]=arr[low];
            }
             arr[low]=stand;
             test2(arr,start,low);
             test2(arr,low+1,end);
        }
        return arr;
    }
}
