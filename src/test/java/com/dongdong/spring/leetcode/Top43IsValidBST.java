package com.dongdong.spring.leetcode;

/**
 * 验证二叉搜索树
 */
public class Top43IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val < lower || root.val > upper) {
            return false;
        }
        return isValidBST(root.left, lower, root.val)
                && isValidBST(root.right, root.val, upper);
    }
}
