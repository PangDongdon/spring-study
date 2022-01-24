package com.dongdong.spring.test.sort;

public class WaterProblem {

    public static  int  getWater(int[] arr){
        if(arr==null || arr.length<3){
            return  0;
        }
        int value=0;
        int leftMax=arr[0];
        int rightMax=arr[arr.length-1];
        int l=0;
        int r=arr.length-2;
        while(l<=r){
            if(leftMax<=rightMax){
                value+=Math.max(0,leftMax-arr[l]);
                leftMax=Math.max(leftMax,arr[l++]);
            }else{
                value+=Math.max(0,rightMax-arr[l]);
                leftMax=Math.max(rightMax,arr[r--]);
            }
        }
        return  value;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{2,1,4};
        System.out.println(getWater(arr));
    }
}
