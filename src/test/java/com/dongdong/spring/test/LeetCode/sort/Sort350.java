package com.dongdong.spring.test.leetCode.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 两个数组的交集 II
 * @Date: 2020/9/4  14:13
 * @Author: dongdong
 */
public class Sort350 {

    public static class Solution1{
        public int[] intersect(int[] nums1,int[] nums2){
            Map<Integer,Integer> map=new HashMap<>();
            for(int i: nums1){
                map.put(i,map.getOrDefault(i,0)+1);
            }
            List<Integer> list=new ArrayList<>();
            for(int i:nums2){
                if(map.containsKey(i) && map.get(i)>0){
                    list.add(i);
                    //map.put(i,map.get(i)-1);
                }
            }
            return  list.stream().distinct().mapToInt(i->i).toArray();
        }
        @Test
        public  void test(){
            int[] a1={1,2,2,1};
            int[] a2={2,2};
            int[] a3= intersect(a1,a2);
            for(int i:a3)
            System.out.print(i+" ");
        }

    }

    @Test
    public  void test(){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(1,map.getOrDefault(1,0)+1);
        System.out.println(map.get(1));
    }
}
