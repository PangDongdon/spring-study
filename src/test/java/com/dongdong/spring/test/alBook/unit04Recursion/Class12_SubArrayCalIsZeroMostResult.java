package com.dongdong.spring.test.alBook.unit04Recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 子数组异或和位0的最多划分
 */
public class Class12_SubArrayCalIsZeroMostResult {

    public static int mostEOR(int[] arr) {
        if (arr == null || arr.length < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[arr.length];
        dp[0] = arr[0] == 0 ? 1 : 0;
        map.put(arr[0], 0);
        int eor = 0;
        for (int i = 1; i < arr.length; i++) {
            eor ^= arr[i];
            if (map.containsKey(eor)) {
                int preIndex = map.get(eor);
                dp[i] = preIndex == -1 ? 1 : dp[preIndex] + 1;
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
            map.put(eor, i);
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 9, 0, 7, 0, 2, 1, 3};
        System.out.println(mostEOR(arr));
    }
}
