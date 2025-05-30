package com.dongdong.spring.leetcodetop100_2;
/**
 * 多数元素
 **/
public class Top97MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }
}
