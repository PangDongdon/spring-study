package com.dongdong.spring.test2.sort.basic_class2;

//无序数组有序后相邻之间的最大值
public class MaxValueByBucket {

    public static int getMaxValueByBucket(int[] arr) {
        if (arr == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        if (max == min) {
            return 0;
        }
        int length = arr.length;
        boolean[] hasNum = new boolean[length + 1];
        int[] minNum = new int[length + 1];
        int[] maxNum = new int[length + 1];

        for (int i = 0; i < length; i++) {
            int bid = buckeId(arr[i], length, min, max);
            minNum[bid] = hasNum[bid] ? Math.min(max, arr[i]) : arr[i];
            maxNum[bid] = hasNum[bid] ? Math.max(max, arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int lastMax = maxNum[0];
        int i = 1;
        int res = 0;
        for (; i < length + 1; i++) {
            if (hasNum[i]) {
                res = Math.max(minNum[i] - lastMax, res);
                lastMax=maxNum[i];
            }
        }
        return res;
    }

    private static int buckeId(int num, int length, int min, int max) {
        return (num - min) * length / (max - min);
    }
}
