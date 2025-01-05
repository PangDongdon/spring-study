package com.dongdong.spring.leetcodetop100_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 旋转矩阵
 */
public class Top19SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return res;
        }
        int tr = 0;
        int tc = 0;
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;
        while (tr <= dr && tc <= dc) {
            addData(matrix, tr++, tc++, dr--, dc--, res);
        }
        return res;
    }

    private void addData(int[][] matrix, int tr, int tc, int dr, int dc, List<Integer> res) {
        if (tr == dr) {
            for (int i = tc; i <= dc; i++) {
                res.add(matrix[tr][i]);
            }
        } else if (dc == tc) {
            for (int i = tr; i <= dr; i++) {
                res.add(matrix[i][tc]);
            }
        } else {
            int curR = tr;
            int curC = tc;
            while (curC != dc) {
                res.add(matrix[tr][curC]);
                curC++;
            }
            while (curR != dr) {
                res.add(matrix[curR][dc]);
                curR++;
            }
            while (curC != tc) {
                res.add(matrix[dr][curC]);
                curC--;
            }
            while (curR != tr) {
                res.add(matrix[curR][tc]);
                curR--;
            }
        }
    }
}
