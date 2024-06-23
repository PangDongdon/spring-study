package com.dongdong.spring.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class Top36InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        addTreeNode(root, res);
        return res;
    }

    private void addTreeNode(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        addTreeNode(root.left, res);
        res.add(root.val);
        addTreeNode(root.right, res);
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            res.add(cur1.val);
            cur1 = cur1.right;
        }
        return res;
    }
}
