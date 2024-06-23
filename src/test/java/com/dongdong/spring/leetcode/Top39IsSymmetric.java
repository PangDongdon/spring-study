package com.dongdong.spring.leetcode;

/**
 * 对称二叉树
 */
public class Top39IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode root, TreeNode root1) {
        if (root == null && root1 == null) {
            return true;
        }
        if (root == null || root1 == null) {
            return false;
        }
        return root.val == root1.val && check(root.left, root1.right)
             && check(root.right, root1.left);
    }
}
