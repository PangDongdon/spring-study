package com.dongdong.spring.test.alBook.unit03Tree;

/**
 * 判断二叉树是否是平衡二叉树
 */
public class Class13_TreeIsBalanceTree {

    public static class ReturnType {
        private boolean isBalance;
        private int height;

        public ReturnType(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    private static boolean isBalance(Node head) {
        return process(head).isBalance;
    }

    private static ReturnType process(Node head) {
        if (head == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);
        int height = Math.max(leftData.height, rightData.height) + 1;
        boolean isBalance = leftData.isBalance
                && rightData.isBalance && Math.abs(leftData.height - rightData.height) < 2;
        return new ReturnType(isBalance, height);
    }

}
