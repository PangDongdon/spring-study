package com.dongdong.spring.leetcode;

/**
 * 二叉树中的最大路径和
 */
public class Top50MaxPathSum {
    Integer max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right),0);
        int all = root.val + leftGain + rightGain;
        max = Math.max(all, max);
        return root.val + Math.max(rightGain, leftGain);
    }
}
