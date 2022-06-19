package com.dongdong.spring.test.sort5.study;

public class Code01_SortedRatateArrayFindMin {

    public static int getMin(int[] arr) {
        {
            if (arr == null) {
                return -1;
            }
            int L = 0;
            int R = arr.length - 1;

            while (L < R) {

                if (L + 1 == R) {
                    break;
                }
                if (arr[L] < arr[R]) {
                    return arr[L];
                }

                int mid = (L + R) / 2;
                if (arr[mid] < arr[L]) {
                    R = mid;
                    continue;
                }
                if (arr[mid] > arr[R]) {
                    L = mid;
                    continue;
                }

                while (L < mid) {
                    if (arr[L] == arr[mid]) {
                        L++;
                    } else if (arr[L] < arr[mid]) {
                        return arr[L];
                    } else {
                        R = mid;
                        break;
                    }
                }
            }
            return Math.min(arr[L], arr[R]);
        }
    }

    public static void main(String[] args) {
        int[] test = { 4, 5, 5, 5, 1, 2, 3 };
        System.out.println(getMin(test));
    }
}
