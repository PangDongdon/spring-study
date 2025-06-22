package com.dongdong.spring.leetcodetop100_3;
/**
 *盛最多的水容器
 */
public class Top5MaxArea {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int ans=0;
        while (left<right){
            int area=Math.min(height[left],height[right])*(right-left);
            if(height[left]<=height[right]){
                left++;
            }else {
                right--;
            }
            ans=Math.max(ans,area);
        }
        return ans;
    }
}
