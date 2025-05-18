package com.dongdong.spring.leetcodetop100_2;

public class Top68FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;

        int totalLeft = (m + n + 1) / 2;
        int left = 0;
        int right = m;
        while (left < right) {
            int i = (right - left + 1) / 2 + left;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int num1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num1LeftMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int num2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num2LeftMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 1) {
            return Math.max(num1LeftMax, num2LeftMax);
        } else {
            return (double) ((Math.max(num1LeftMax, num2LeftMax))
                    + (Math.min(num1LeftMin, num2LeftMin))) / 2;
        }
    }

}
