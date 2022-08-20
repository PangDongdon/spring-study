package com.dongdong.spring.test.alBook.unit03Tree;

import lombok.Data;

//找到二叉树中的最大搜索二叉子树
public class Class07_FindTreeMaxSearchTree {

    public static class ReturnType {
        private Node maxBSTHead;
        private int maxBSTSize;
        private int min;
        private int max;

        public ReturnType(Node maxBSTHead, int maxBSTSize, int min, int max) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnType process(Node node) {
        if (node == null) {
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        //获取左子树数据
        ReturnType lData = process(node.left);
        //或取右子树数据
        ReturnType rData = process(node.right);
        int min = Math.min(node.value, Math.min(lData.min, rData.min));
        int max = Math.max(node.value, Math.max(lData.max, rData.max));
        int maxBSTSize = Math.max(lData.maxBSTSize, rData.maxBSTSize);
        Node maxBSTHead = lData.maxBSTSize >= rData.maxBSTSize ? lData.maxBSTHead : rData.maxBSTHead;
        if (lData.maxBSTHead == node.left && rData.maxBSTHead == node.right
                && lData.max < node.value && rData.min > node.value) {
            maxBSTSize = lData.maxBSTSize + rData.maxBSTSize + 1;
            maxBSTHead = node;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }

    public static Node findMaxSearchTree(Node head) {
        return process(head).maxBSTHead;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);
        System.out.println(findMaxSearchTree(node).value);
    }
}
