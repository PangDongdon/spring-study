package com.dongdong.spring.leetcode;

/**
 * 将有序数组转化为二叉搜索树
 */
public class Top42sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left < right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, 0, mid);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
