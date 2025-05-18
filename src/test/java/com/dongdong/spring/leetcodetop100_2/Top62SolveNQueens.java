package com.dongdong.spring.leetcodetop100_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Top62SolveNQueens {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] dashboard = new char[n][n];
        //初始化数据
        for (char[] c : dashboard) {
            Arrays.fill(c, '.');
        }
        backtraking(dashboard, n, 0);
        return res;
    }

    private void backtraking(char[][] dashboard, int n, int row) {
        //递归的终止条件
        if (row == n) {
            res.add(arrayToList(dashboard));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(i, row, dashboard, n)) {
                dashboard[row][i] = 'Q';
                //另外一层的遍历
                backtraking(dashboard, n, row + 1);
                //回溯
                dashboard[row][i] = '.';
            }
        }
    }

    private boolean isValid(int col, int row, char[][] dashboard, int n) {
        //列检查
        for (int i = 0; i < row; i++) {
            if (dashboard[i][col] == 'Q') {
                return false;
            }
        }
        //45度检查
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (dashboard[i][j] == 'Q') {
                return false;
            }
        }
        //135度检查
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (dashboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> arrayToList(char[][] dashboard) {
        List<String> path = new ArrayList<>();
        for (char[] c : dashboard) {
            path.add(String.copyValueOf(c));
        }
        return path;
    }
}
