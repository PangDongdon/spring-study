package com.dongdong.spring.leetcode;

/**
 * 翻转二叉树
 */
public class Top38InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode tmp=root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
