package com.dongdong.spring.test2.sort.basic_class2;

public class SmallSum {

    public static int sum(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return mergeSort(arr, left, mid)
                + mergeSort(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

    private static int merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            res += arr[p1] <= arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[left + j] = help[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 0};
        System.out.println(mergeSort(arr, 0, arr.length - 1));
    }
}
