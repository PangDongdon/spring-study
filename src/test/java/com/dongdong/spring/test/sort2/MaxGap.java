package com.dongdong.spring.test.sort2;

import org.junit.Test;

import javax.validation.constraints.Max;

/**
 *得到有序相邻两数的最大的差值
 */
public class MaxGap {

    public  int  getMaxGap(int[] arr){
        if(arr==null || arr.length<2){
            return 0;
        }
        //获取桶中最小及最大的数值
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            min=Math.min(arr[i],min);
            max=Math.max(arr[i],max);
        }
        if(min==max){
            return  0;
        }
        int length=arr.length;
        boolean[] hasNum=new boolean[length+1];
        int[] mins=new int[length+1];
        int[] maxs=new int[length+1];
        int bid=0;
        for(int i=0;i<length;i++){
            bid=getBucketNum(arr[i],length,max,min);
            mins[bid]=hasNum[i] ? Math.min(mins[bid],arr[i]) :arr[i];
            maxs[bid]=hasNum[i] ? Math.max(maxs[bid],arr[i]) :arr[i];
            hasNum[bid]=true;
        }

        int res=0;
        int maxValue=maxs[0];
        int i=1;
        for(;i<=length;i++){
            if(hasNum[i]){
                res= Math.max(mins[i]-maxValue,res);
                maxValue=maxs[i];
            }
        }
       return res;
    }


    //获取桶的序号
     public int getBucketNum(int val,int length,int max,int min){
        /*return (int)((val-min)*length/(max-min));*/
         return (int) ((val - min) * length / (max - min));
     }

     @Test
    public void test(){
        System.out.println(getMaxGap(JavaUtil.s));
     }
}
