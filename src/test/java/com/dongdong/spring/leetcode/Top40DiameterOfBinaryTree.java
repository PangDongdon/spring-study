package com.dongdong.spring.leetcode;

/**
 * 二叉树的最大直径
 */
public class Top40DiameterOfBinaryTree {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        getMaxDepth(root);
        return ans - 1;
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getMaxDepth(root.left);
        int r = getMaxDepth(root.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }
}
