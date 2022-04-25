package com.dongdong.spring.test.sort3.test.unit03;

import advanced_class_03.Code_01_SortedArrayToBalancedBST;

public class SortedArrayToBalancedBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    private static Node generateTree(int[] sortArray) {
        if (sortArray == null) {
            return null;
        }
        return generate(sortArray,0,sortArray.length-1);
    }

    private static Node generate(int[] sortArray, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        Node head = new Node(sortArray[mid]);
        head.left = generate(sortArray, left, mid - 1);
        head.right = generate(sortArray, mid+1, right);
        return head;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printTree(generateTree(arr));
    }
}
