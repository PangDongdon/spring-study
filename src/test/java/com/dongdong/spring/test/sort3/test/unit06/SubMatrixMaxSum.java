package com.dongdong.spring.test.sort3.test.unit06;

public class SubMatrixMaxSum {

    public static  int getMaxSum(int[][] arr){
        if(arr==null || arr.length==0 || arr[0].length==0){
            return  0;
        }
        int cur=0;
        int max=Integer.MIN_VALUE;
        int[] s=null;
        for(int i=0;i<arr.length;i++){
            s=new int[arr[0].length];
            for(int j=i;j<arr.length;j++){
                cur=0;
                for(int k=0;k<s.length;k++){
                    s[k]+=arr[j][k];
                    cur+=s[k];
                    max=Math.max(max,cur);
                    cur=cur>0?cur:0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
        System.out.println(getMaxSum(matrix));
    }
}
