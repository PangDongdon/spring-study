package com.dongdong.spring.test.sort3.test.unit01;

import java.util.LinkedList;

public class AllLessNumSubArray {

    public static int getSum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();
        int L = 0;
        int R = 0;
        int res=0;
        while (L < arr.length) {
            while (R < arr.length) {
                while (!min.isEmpty() && arr[min.peekLast()] >= arr[R]) {
                    min.pollLast();
                }
                min.addLast(R);
                while (!max.isEmpty() && arr[max.peekLast()] <= arr[R]) {
                    max.pollLast();
                }
                max.addLast(R);
                if(arr[max.getFirst()]-arr[min.getFirst()]>num){
                    break;
                }
                R++;
            }
            if(min.peekFirst()==L){
                min.pollFirst();
            }
            if(max.peekFirst()==L){
                max.pollFirst();
            }
            res+=R-L;
            L++;
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] arr = getRandomArray(30);
        int[] arr={4 ,1 ,5, 2, 7, 1, 8, 5, 7, 1 ,1, 2, 4, 3 ,4, 9, 6, 3, 7 ,2, 5 ,1, 9 ,0, 6, 6, 8, 1, 7, 5 };
        int num = 5;
       // printArray(arr);
        System.out.println(getSum(arr, num));

    }
}
