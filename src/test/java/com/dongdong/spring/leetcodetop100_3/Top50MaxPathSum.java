package com.dongdong.spring.leetcodetop100_3;

/**
 * 二叉树最长路径和
 **/
public class Top50MaxPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);
        int all = root.val + left + right;
        max = Math.max(max, all);
        return root.val + Math.max(left, right);
    }
}
