package com.dongdong.spring.leetcode;
/**
 *搜索插入位置
 */
public class Top63SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int n=nums.length;
        int right=n-1;
        int ans= n;
        while(left<=right){
            int mid=((right-left)>>1)+left;
            if(target<=nums[mid]){
                ans=mid;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return ans;
    }
}
