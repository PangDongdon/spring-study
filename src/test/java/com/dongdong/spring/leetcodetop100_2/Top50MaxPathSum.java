package com.dongdong.spring.leetcodetop100_2;

public class Top50MaxPathSum {
    int max = Integer.MAX_VALUE;

    public int maxPathSum(TreeNode root) {
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
