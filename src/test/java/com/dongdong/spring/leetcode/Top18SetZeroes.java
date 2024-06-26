package com.dongdong.spring.leetcode;


import com.dongdong.spring.test.alBook.Utils;

/**
 * 矩阵置零
 */
public class Top18SetZeroes {

    public static void setZeroes(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        boolean flagCol0 = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }


    public static void main(String[] args) {
        //给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法
        //输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
        //输出：[[1,0,1],[0,0,0],[1,0,1]]
        int[][] s = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(s);
        Utils.printData(s);

        //输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        //输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]
    }
}
