package com.dongdong.spring.leetcode;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

import java.util.*;

/**
 * 滑动窗口的最大值
 */
public class Top11MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int right = left + k - 1;
        int i = 0;
        while (right < nums.length) {
            res[i++] = getMax(nums, left, right);
            left++;
            right = left + k - 1;
        }
        return res;
    }

    private static int getMax(int[] arr, int left, int right) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(arr[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        //输出：[3,3,5,5,6,7]
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        PrintArray.printArrayElement(maxSlidingWindow(a, k));


        //输入：nums = [1], k = 1
        //输出：[1]

        int[] a2 = {1};
        int k2 = 1;
        PrintArray.printArrayElement(maxSlidingWindow(a2, k2));
    }


    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
        }
        int[] res = new int[n - k + 1];
        res[0] = priorityQueue.peek()[0];
        for (int i = k; i < n; i++) {
            priorityQueue.offer(new int[]{nums[i], i});
            while (priorityQueue.peek()[1] <= i - k) {
                priorityQueue.poll();
            }
            res[i - k + 1] = priorityQueue.peek()[0];
        }
        return res;
    }

    public static int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] res = new int[n - k + 1];
        res[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            while (deque.peekFirst() <= n - k) {
                deque.pollFirst();
            }
            res[i - k + 1] = nums[deque.peekFirst()];
        }
        return res;
    }
}
