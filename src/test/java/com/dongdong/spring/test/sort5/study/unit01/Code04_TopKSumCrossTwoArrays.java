package com.dongdong.spring.test.sort5.study.unit01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code04_TopKSumCrossTwoArrays {

    public static class Node {
        private int num1; //数组1的下标
        private int num2; //数组2的下标
        private int sum;  //arr[num1]+ar[num2]

        public Node(int num1, int num2, int sum) {
            this.num1 = num1;
            this.num2 = num2;
            this.sum = sum;
        }
    }

    //定义比较器
    public static class TopKComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.sum - o1.sum;
        }
    }

    public static int[] getTopKArr(int[] arr1, int[] arr2, int k) {
        if (arr1 == null || arr2 == null || k < 0) {
            return null;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(new TopKComparator());
        int topK = Math.min(k, arr1.length + arr2.length);
        boolean[][] isAdd = new boolean[arr1.length][arr2.length];
        int[] res = new int[topK];
        int index1 = arr1.length - 1;
        int index2 = arr2.length - 1;
        queue.add(new Node(index1, index2, arr1[index1] + arr2[index2]));
        isAdd[index1][index2] = true;
        int index = 0;
        while (index != topK) {
            Node node = queue.poll();
            res[index++] = node.sum;
            index1=node.num1;
            index2=node.num2;
            if (index1 - 1 > 0 && !isAdd[index1 - 1][index2]) {
                isAdd[index1 - 1][index2] = true;
                queue.add(new Node(index1 - 1, index2, arr1[index1 - 1] + arr2[index2]));
            }
            if (index2 - 1 > 0 && !isAdd[index1][index2 - 1]) {
                isAdd[index1][index2 - 1] = true;
                queue.add(new Node(index1, index2 - 1, arr1[index1] + arr2[index2 - 1]));
            }
        }
        return res;
    }

    public static int[] generateRandomSortArray(int len) {
        int[] res = new int[len];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * 50000) + 1;
        }
        Arrays.sort(res);
        return res;
    }

    public static int[] topKSumTest(int[] arr1, int[] arr2, int topK) {
        int[] all = new int[arr1.length * arr2.length];
        int index = 0;
        for (int i = 0; i != arr1.length; i++) {
            for (int j = 0; j != arr2.length; j++) {
                all[index++] = arr1[i] + arr2[j];
            }
        }
        Arrays.sort(all);
        int[] res = new int[Math.min(topK, all.length)];
        index = all.length - 1;
        for (int i = 0; i != res.length; i++) {
            res[i] = all[index--];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i != arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a1Len = 5000;
        int a2Len = 4000;
        int k = 2000;
        int[] arr1 = generateRandomSortArray(a1Len);
        int[] arr2 = generateRandomSortArray(a2Len);
        long start = System.currentTimeMillis();
        int[] res = getTopKArr(arr1, arr2, k);
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");

        start = System.currentTimeMillis();
        int[] absolutelyRight = topKSumTest(arr1, arr2, k);
        end = System.currentTimeMillis();
        System.out.println(end - start + " ms");

        System.out.println(isEqual(res, absolutelyRight));
    }
}
