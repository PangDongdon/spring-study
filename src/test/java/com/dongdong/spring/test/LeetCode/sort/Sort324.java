package com.dongdong.spring.test.leetCode.sort;

import org.junit.Test;
import org.springframework.security.core.parameters.P;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Description: 摆动排序2
 * @Date: 2020/9/3  10:26
 * @Author: dongdong
 */
public class Sort324 {

    public  void  swingSort( int[] a){
        Arrays.sort(a);
        int[] ss=new int[a.length];
       for(int i=0;i<a.length;i++) {
           if (a.length % 2 == 0) {
               if (i < a.length / 2) {
                   ss[2 * i] = a[i];
               } else if (i >= a.length / 2 && i < a.length) {
                   ss[(i - a.length / 2) * 2 + 1] = a[i];
               }
           }else{
               if (i < a.length / 2+1) {
                   ss[2 * i] = a[i];
               } else if (i >= a.length / 2+1 && i < a.length) {
                   //System.out.println((i - a.length / 2+1) * 2 + 1+":  "+i);
                   ss[(i - (a.length / 2+1)) * 2 + 1] = a[i];
               }
           }
       }
       for(int i=0;i<ss.length;i++){
           System.out.print(ss[i]+" ");
       }
    }

    @Test
    public void test(){
         int[] a={1,5,1,1,6};

         swingSort(a);
        //System.out.println(5/2);
    }


    /** leetcode 解法*/
    public  void wiggleSort(int[] nums){
       int median=findKthLargest(nums,(nums.length+1)/2);
       int n=nums.length;

       int left=0;

       int i=0;
       int right=n-1;
       while(i<=right){
           if(nums[newIndex(i,n)]>median){
               swap(nums,newIndex(left++,n),newIndex(i++,n));
           }else if(nums[newIndex(i,n)]<median){
               swap(nums,newIndex(right--,n),newIndex(i,n));
           }else{
               i++;
           }
       }
    }

    private int findKthLargest(int [] nums,int k){ //push & pop  offer & poll
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<nums.length;i++){
            maxHeap.offer(nums[i]);
        }
        while(k-- >1){
            maxHeap.poll();
        }
         return  maxHeap.poll();
    }

    private void swap(int [] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }


    private  int newIndex(int index,int n){
      return (1+2*index)%(n|1);
    }

}
