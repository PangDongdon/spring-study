package com.dongdong.spring.leetcodetop100_3;
/**
 *寻找重复数
 */
public class Top103FindDuplicate {
    public int findDuplicate(int[] nums) {
     int slow = 0;
     int fast = 0;
        do {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while (slow!=fast);
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
