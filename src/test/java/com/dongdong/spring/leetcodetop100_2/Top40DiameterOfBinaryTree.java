package com.dongdong.spring.leetcodetop100_2;

/**
 * 二叉树的直径
 */
public class Top40DiameterOfBinaryTree {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        deep(root);
        return ans - 1;
    }

    private int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        ans = Math.max(ans, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
