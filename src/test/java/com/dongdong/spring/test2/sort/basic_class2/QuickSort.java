package com.dongdong.spring.test2.sort.basic_class2;

public class QuickSort {

    public static void quickSort(int[] arr, int L, int R) {
        if (arr == null) {
            return;
        }
        if (L < R) {
            Utils.swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] partition = partition(arr, L, R);
            quickSort(arr, L, partition[0] - 1);
            quickSort(arr, partition[1] + 1, R);
        }
    }

    public static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        while (L < more) {
            if (arr[L] < arr[R]) {
                Utils.swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                Utils.swap(arr, --more, L);
            } else {
                L++;
            }
        }
        Utils.swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 7, 4};
        quickSort(arr, 0, arr.length - 1);
        Utils.printArrRes(arr);
    }
}
