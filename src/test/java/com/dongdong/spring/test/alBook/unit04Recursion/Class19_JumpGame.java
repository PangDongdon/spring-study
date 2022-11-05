package com.dongdong.spring.test.alBook.unit04Recursion;

/**
 * 跳跃游戏
 */
public class Class19_JumpGame {

    public static int jump(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int jump = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }

    public static void main(String[] args) {
        int[] arr ={3, 2, 1, 1, 4};
        System.out.println(jump(arr));
    }
}
