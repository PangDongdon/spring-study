package com.dongdong.spring.leetcodetop100_2;
/**
 *缺失的第一个正数
 */
public class Top17FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int length=nums.length;
        for(int i=0;i<length;i++){
            while(nums[i]>0  && nums[i]<length && nums[nums[i]-1]!=nums[i]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        for(int i=0;i<length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return length+1;
    }
}
