package com.dongdong.spring.test2.sort.basic_class1;

import com.dongdong.spring.test2.sort.CommonUtils;

/**
 * @author dongDong.pang
 * @date 2021/8/4 19:11
 */
public class MergeSort {


    private static  void mergeSort(int[] arr){
        if(arr.length<2){
            return;
        }
       mergeSort(arr,0,arr.length-1);
       //print
       CommonUtils.printData(arr);

    }

    private static  void  mergeSort(int[] arr,int l,int r){
        if(l==r){
            return;
        }
        int mid=l+((r-l)>>1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        //merge
        merge(arr,l,mid,r);
    }

    private  static void   merge(int[] arr,int l,int m,int r){
      int[] help=new int[r-l+1];
      int i=0;
      int p1=l;
      int p2=m+1;
      while(p1<=m && p2<=r){
          help[i++]=arr[p1]<arr[p2]? arr[p1++]:arr[p2++];
      }
      while(p1<=m){
          help[i++]=arr[p1++];
      }
      while(p2<=r){
          help[i++]=arr[p2++];
      }
      //CommonUtils.printData(help);
      //copy
        for(int j=0;j<help.length;j++){
            arr[l+j]=help[j];
        }
    }

    public static void main(String[] args) {
        mergeSort(CommonUtils.arr);
    }
}
