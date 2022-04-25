package com.dongdong.spring.test.sort3.test.unit05;

import java.util.Arrays;

public class Min_Gold {

    public static int getMinGold(int[] knights, int[] dragons) {
        if (knights == null || dragons == null) {
            return 0;
        }
        //对勇士进行排序
        Arrays.sort(knights);
        //遍历龙
        int res = 0;
        for (int dragon : dragons) {
            int s = selectKnght(knights, dragon);
            if (s == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            res += s;
        }
        return res;
    }


    public static int getMinGold2(int[] knights, int[] dragons) {
        if (knights == null || dragons == null) {
            return 0;
        }
        //求勇士武功和
        int sum = 0;
        for (int i = 0; i < knights.length; i++) {
            sum += knights[i];
        }
        //新建dp
        int[] dp = new int[sum + 1];
        for (int i = 1; i <= sum; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[knights[0]] = knights[0];

        for (int i = 1; i < knights.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - knights[i] >= 0 && dp[j - knights[i]] < Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - knights[i]] + knights[i]);
                }
            }
        }

        //遍历dp
        for (int i = dp.length - 2; i >=0; i--) {
            dp[i] = Math.min(dp[i], dp[i + 1]);
        }
        printArray(dp);
        //0 2 2 5 5 5 7 7 10 10 10 12 12 15 15 15 17 17
        //计算
        //遍历龙
        int res = 0;
        for (int dragon : dragons) {
            int s = selectKnght(dp, dragon);
            if (s == Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            res += s;
        }
        return res;
    }

    private static int selectKnght(int[] knights, int dragon) {
        int l = 0;
        int r = knights.length - 1;
        int index = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (knights[mid] < dragon) {
                l = mid + 1;
            } else {
                index = mid;
                r = mid - 1;
            }
        }
        return index == -1 ? Integer.MAX_VALUE : knights[index];
    }

    public static void printArray(int[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print((dp[i] == Integer.MAX_VALUE ? "X" : dp[i]) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] knights1 = {2, 10, 5};
        int[] dragons1 = {3, 8, 6};
        System.out.println(getMinGold(knights1, dragons1));

        int[] knights2 = {2, 10, 5};
        int[] dragons2 = {3, 8, 6};
        System.out.println(getMinGold2(knights2, dragons2));

    }
}
