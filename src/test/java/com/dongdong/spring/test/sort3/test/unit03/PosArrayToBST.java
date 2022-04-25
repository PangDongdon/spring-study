package com.dongdong.spring.test.sort3.test.unit03;

import advanced_class_04.Code_03_PosArrayToBST;

public class PosArrayToBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static boolean isPostArray(int[] arr) {
        if (arr == null || arr.length < 1) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }

    public static boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int lessRight = -1;
        int moreLeft = end;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                lessRight = i;
            } else {
                moreLeft = moreLeft == end ? i : moreLeft;
            }
        }
        if (lessRight == -1 || moreLeft == end) {
            return isPost(arr, start, end - 1);
        }
        if (lessRight != moreLeft - 1) {
            return false;
        }
        return isPost(arr, start, lessRight) && isPost(arr, moreLeft, end - 1);
    }


    public static Node posArrayToBST(int[] arr) {
        if (arr == null) {
            return null;
        }
        return posToBST(arr, 0, arr.length - 1);
    }

    public static Node posToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int less = -1;
        int more = end;
        Node head = new Node(arr[end]);
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        head.left = posToBST(arr, start, less);
        head.right = posToBST(arr, more, end - 1);
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
        int[] arr = {2, 1, 3, 6, 5, 7, 4};
        System.out.println(isPost(arr, 0, arr.length - 1));
        printTree(posArrayToBST(arr));

    }
}
