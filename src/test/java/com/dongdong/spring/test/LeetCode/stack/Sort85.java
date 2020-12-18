package com.dongdong.spring.test.leetCode.stack;

import java.util.Arrays;

/**
 * @Description:
 * @Date: 2020/12/18  16:12
 * @Author: dongdong
 */
public class Sort85 {

    public int getMaxRectangle(char[][] matrix){
        if(matrix.length==0){  //[
                               // [1,0,1,0,0],
                               // [1,0,1,1,1],
                               // [1,1,1,1,1],
            return 0;          // [1,0,0,1,0]
                                    // ]
        }
        int m=matrix.length; //4
        int n=matrix[0].length; //5
        int[] left=new int[n];
        int[] right=new int[n];
        int[] height=new int[n];
        Arrays.fill(left,0);
        Arrays.fill(right,0);
        Arrays.fill(height,0);
        int maxA=0;
        for(int i=0;i<m;i++){
            int currLeft=0;
            int currRight=n;//5
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    //记录列为1的总和
                    height[j]++;
                }else{
                    height[j]=0;
                }
            }
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='1'){
                    left[j]=Math.max(left[j],currLeft);
                }else{
                    left[j]=0;
                    currLeft=j+1;
                }
            }
            for(int j=n-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    right[j]=Math.min(right[j],currRight);
                }else{
                    right[j]=n;
                    currRight=j;
                }
            }
            for(int j=0;j<n;j++){
                maxA=Math.max(m,(right[j]-left[j])*height[j]);
            }
        }
        return maxA;
    }
}
