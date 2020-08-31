package com.dongdong.spring.test.leetCode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description: 最大间距 ：给定无序的数组，排序后找出最大差值。
 * @Date: 2020/8/31  15:41
 * @Author: dongdong
 */
public class Sort164 {

    public int lookMaxSub(int[] a){
        //对数组进行排序
        Arrays.sort(a);
        //对已经排好的数组进行操作
        int max=0;
        if(a.length<2){
            return  0;
        }
        for(int i=0;i<a.length-1;i++){
            int ss=a[i+1]-a[i];
            if(ss>max){
                max=ss;
            }
        }
        return  max;
    }
    @Test
    public void test(){
      int[] ss={1,3,6,9,90};
      System.out.println(lookMaxSub(ss));
    }

    public static class Solution1{
        public int maximumGap(int[] nums){
            if(nums.length<2){
                return  0;
            }
            Arrays.sort(nums);
            int max=Integer.MIN_VALUE;
            for(int i=1;i<nums.length;){
                while(i<nums.length && nums[i]==nums[i-1]){
                    i++;
                }
                if(i==nums.length){
                    i--;
                    max=(nums[i]-nums[i-1]>max) ? nums[i]-nums[i-1] :max;
                    break;
                }else{
                    max=(nums[i]-nums[i-1]>max) ? nums[i]-nums[i-1] :max;
                }
                if(nums[i]!=nums[i-1]){
                    i++;
                }
            }
            return  max;
        }

        @Test
        public void test(){
            int[] ss={1,3,6,9,90};
            System.out.println(maximumGap(ss));
        }
    }




}
