package com.dongdong.spring.leetcodetop100_3;

/**
 * 验证二叉搜索树
 **/
public class Top43IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValidBST(root.left, minValue, root.val)
                && isValidBST(root.right, root.val, maxValue);
    }
}
