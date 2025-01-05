package com.dongdong.spring.leetcode;

/**
 * 二叉树的最大深度
 */
public class Top37MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
