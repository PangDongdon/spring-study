package com.dongdong.spring.test.alBook.unit03Tree;

import net.dongliu.commons.Sys;

/**
 * 根据后序数组重建搜索二叉树
 */
public class Class14_ArrRebuildSearchTree {

    public static boolean isPostArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return isPost(arr, 0, arr.length - 1);
    }

    public static boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        if (less == -1 || more == end) {
            return isPost(arr, start, end - 1);
        }
        if (less != more - 1) {
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }


    //rebuild tree
    private static Node postArrayToBST(int[] arr) {
        if (arr == null) {
            return null;
        }
        return postToBST(arr, 0, arr.length - 1);
    }

    private static Node postToBST(int[] arr, int start, int end) {
        if (arr == null || start > end) {
            return null;
        }
        Node head = new Node(arr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[end]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }
        head.left = postToBST(arr, start, less);
        head.right = postToBST(arr, more, end-1);
        return head;
    }


    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 6, 5, 7, 4};
        //System.out.println(isPostArray(arr));
        System.out.println(postArrayToBST(arr).value);
    }

}
