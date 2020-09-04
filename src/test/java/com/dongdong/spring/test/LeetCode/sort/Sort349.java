package com.dongdong.spring.test.leetCode.sort;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Description: 两个数组的交集
 * @Date: 2020/9/4  13:04
 * @Author: dongdong
 */
public class Sort349 {
    public int [] getIntersectionOfArray(int[] a1,int[] a2){
        Arrays.sort(a1);
        Arrays.sort(a2);
        Set<Integer> intersect=new HashSet<>();
        for(int i:a1){
            if(binarySearch(i,a2)){
                intersect.add(i);
            }
        }
        int[] result=new int[intersect.size()];
        Iterator<Integer> it=intersect.iterator();
        for(int i=0;i<intersect.size();i++){
            result[i]=it.next();
        }
        return result;
    }
    private boolean binarySearch(int i,int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==i){
                return true;
            }else if(nums[i]>i){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return  false;
    }
}
