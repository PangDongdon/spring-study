package com.dongdong.spring.leetcodetop100_3;
/**
 *旋转图像：给定一个 n×n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 */
public class Top20Rotate {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        //水平翻转
        for(int i=0;i<m/2;i++){
            for(int j=0;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[m-i-1][j];
                matrix[m-i-1][j]=temp;
            }
        }
        //按对角线翻转
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}
