package com.dongdong.spring.test.alBook.unit03Tree;

//二叉树的最小深度
public class Class02_BranchTreeMinHeight {

    private static int minDepth1(Node head) {
        if (head == null) {
            return 0;
        }
        return process(head, 1);
    }

    private static int process(Node head, int level) {
        if (head.right == null && head.left == null) {
            return level;
        }
        int ans = Integer.MAX_VALUE;
        //左树
        if (head.left != null) {
            ans = Math.min(process(head.left, level + 1), ans);
        }
        //右树
        if (head.right != null) {
            ans = Math.min(process(head.right, level + 1), ans);
        }
        return ans;
    }

    //moirr
    // todo
    private static int minDepth2() {
        return 0;
    }
}
