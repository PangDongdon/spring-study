package com.dongdong.spring.test.leetCode.sort;

import org.junit.Test;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description: 分类颜色 0:红色 1：白色  2：蓝色
 * @Date: 2020/8/31  13:46
 * @Author: dongdong
 */
public class Sort75 {

    public Integer[]   classificationColor(Integer[] a){
        Map<Integer, Integer> map= new TreeMap<>();
        for(int i=0;i<a.length;i++){
            if(!map.containsKey(a[i])){
                map.put(a[i],1);
            }else {
                map.put(a[i],map.get(a[i])+1);
            }
        }
        System.out.println("map:"+map);
        Integer[] aa=new Integer[a.length];
        int i=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int b=entry.getValue();
            while (b>0){
                aa[i]=entry.getKey();
                i++;
                b--;
            }
        }
        return aa;
    }

    @Test
    public void test(){
        Integer[] dd={2,0,2,1,1,0};
        Integer[] cc=classificationColor(dd);
        for(int i=0;i<cc.length;i++){
            System.out.print(cc[i]+" ");
        }
    }

    public  static  class Solution1{
        public int[] sortColors(int[] num){
          int zero=0;
          int two=num.length-1;
          for(int i=0;i<=two;){
             if(num[i]==0 && i>zero){
                 swap(num,i,zero++);
             }else if(num[i]==2 && i<two){
                 swap(num,i,two--);
             }else{
                 i++;
             }
          }
          return  num;
        }

        void swap(int[] nums,int m,int n){
            int temp=nums[m];
            nums[m]=nums[n];
            nums[n]=temp;
        }

        @Test
        public void test11(){
         int[] dd={2,0,2,1,1,0};
         int[] ss=sortColors(dd);
         for(int i=0;i<ss.length;i++){
             System.out.print(ss[i]+" ");
         }
        }
    }
}
