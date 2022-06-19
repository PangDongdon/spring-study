package com.dongdong.spring.test.sort5.study.unit02;

import java.util.HashMap;
import java.util.Map;

public class Code05_Split4Parts {

    public static boolean canSplits(int[] arr) {
        if (arr == null || arr.length < 7) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            map.put(sum, i);
            sum += arr[i];
        }
        int slum = arr[0];
        for (int s = 1; s < arr.length - 5; s++) {
            int checkSum = 2 * slum + arr[s];
            if (map.containsKey(checkSum)) {
                int s2 = map.get(checkSum);
                checkSum += slum + arr[s2];
                if (map.containsKey(checkSum)) {
                    int s3 = map.get(checkSum);
                    if (checkSum + slum + arr[s3] == sum) {
                        return true;
                    }
                }
            }
            slum += arr[s];
        }
        return false;
    }

    public static int[] generateRondomArray() {
        int[] res = new int[(int) (Math.random() * 10) + 7];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (Math.random() * 10) + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int testTime = 30;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRondomArray();
            if (!canSplits(arr)) {
                System.out.println("Error");
            }
        }
    }

}
