package com.dongdong.spring.leetcodetop100_2;
/**
 *颜色分类
 */
public class Top98SortColors {
    public void sortColors(int[] nums) {
      int len=nums.length;
      if(len<2){
          return;
      }
      int p0=-1;
      int i=0;
      int p2=len;
      while (i<p2){
         if(nums[i]==0){
            swap(nums,++p0,i++);
         }else if(nums[i]==1){
             i++;
         }else {
             swap(nums,--p2,i);
         }
      }
    }

    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
