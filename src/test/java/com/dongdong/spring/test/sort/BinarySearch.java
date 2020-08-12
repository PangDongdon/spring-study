package com.dongdong.spring.test.sort;

import org.junit.Test;

/**
 * @Description:  二分查找
 * @Date: 2020/8/10  11:22
 * @Author: dongdong
 */
public class BinarySearch {

     public int  lookData(int[] array,int a){
         int lo=0;
         int hi=array.length-1;
         int mid;
         while(lo<=hi){
             mid=(hi+lo)/2;//中间位置
             if(array[mid]==a){
                 return  mid;
             }else if(array[mid]>a){
                  hi=mid-1;
             }else  if(array[mid]<a){
                 lo=mid+1;
             }
         }
      return  -1;
     }

     @Test
    public void test(){
         int[] a={1,2,3,4,5};
         System.out.println(lookData(a,2));
     }

}
