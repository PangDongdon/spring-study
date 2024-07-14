package com.dongdong.spring.leetcode;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 二叉搜索树第k小元素
 */
public class Top44KthSmallest {
    public static int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        print(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (i == k-1) {
                return list.get(i);
            }
        }
        return -1;
    }

    private  static void print(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        print(root.left, list);
        list.add(root.val);
        print(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode left=new TreeNode(1);
        root.left=left;
        root.right=new TreeNode(4);
        left.right=new TreeNode(2);
        kthSmallest(root,1);
    }


}
