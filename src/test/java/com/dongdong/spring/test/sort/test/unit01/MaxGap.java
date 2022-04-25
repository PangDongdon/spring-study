package com.dongdong.spring.test.sort.test.unit01;

import com.dongdong.spring.test.sort.test.util.Utils;

//相邻数的最大差值
public class MaxGap {

    public static int getMaxGap(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        if (max == min) {
            return 0;
        }
        int length = arr.length;
        int[] mins = new int[length + 1];
        int[] maxs = new int[length + 1];
        boolean[] hasNum = new boolean[length + 1];
        int bid=0;
        for (int i = 0; i < length; i++) {
            bid = getBid(arr[i], min, max, length);
            mins[bid] = hasNum[bid] ? Math.min(arr[i], mins[bid]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(arr[i], maxs[bid]) : arr[i];
            hasNum[bid] = true;
        }
        int lastMax = maxs[0];
        int res = 0;
        for (int i = 1; i <= length; i++) {
            if (hasNum[i]) {
                res = Math.max(mins[i] - lastMax, res);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    //获取桶号
    public static int getBid(int num, int min, int max, int len) {
        return (int) ((num - min) * len / (max-min));
    }

    public static void main(String[] args) {
        System.out.println(getMaxGap(Utils.arr));
    }
}
