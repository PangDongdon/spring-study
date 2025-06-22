package com.dongdong.spring.leetcodetop100_3;

import java.util.Deque;
import java.util.LinkedList;

/**
 *滑动窗口的最大值
 */
public class Top11MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new LinkedList<>();
        int n=nums.length;
        int[] ans=new int[n-k+1];
        for(int i=0;i<k;i++){
           while (!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
               deque.pollLast();
           }
           deque.offerLast(i);
        }
        ans[0]=nums[deque.peekFirst()];
        for(int i=k;i<n;i++){
            while (!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);

            while (deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            ans[i-k+1]=nums[deque.peekFirst()];
        }
        return ans;
    }
}
