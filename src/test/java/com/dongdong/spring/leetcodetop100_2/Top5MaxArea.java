package com.dongdong.spring.leetcodetop100_2;
/**
 *盛水最多的容器
 */
public class Top5MaxArea {
    public int maxArea(int[] height) {
      int l=0;
      int r=height.length-1;
      int ans=0;
      while (l<r){
          int area=Math.min(height[r],height[l])*(r-l);
          ans=Math.max(ans,area);
          if(height[l]<=height[r]){
              l++;
          }else {
              r--;
          }
      }
      return ans;
    }
}
