package com.dongdong.spring.test.sort3.test2.unit03;

public class JumpGame {

    public static int getTotalStep(int[] arr){
        if(arr==null || arr.length<2){
            return 0;
        }
        int jump=0;
        int cur=0;
        int next=0;
        for(int i=0;i<arr.length;i++){
            if(cur<i){
                jump++;
                cur=next;
            }
            next=Math.max(next,i+arr[i]);
        }
        return  jump;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 3, 1, 1, 4 };
        System.out.println(getTotalStep(arr));
    }

}
