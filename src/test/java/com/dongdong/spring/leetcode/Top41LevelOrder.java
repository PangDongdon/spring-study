package com.dongdong.spring.leetcode;

import java.util.*;

/**
 * 层序遍历
 */
public class Top41LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> part = new ArrayList<>();
            int size = deque.size();
            for (int i = 1; i <= size; i++) {
                TreeNode node = deque.poll();
                part.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            res.add(part);
        }
        return res;
    }
}
