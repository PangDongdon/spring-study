package com.dongdong.spring.leetcodetop100_2;

/**
 * 单词搜索
 */
public class Top60Exist {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || word == null || word.length() < 1) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        char fistChar = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == fistChar && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        //边界检查
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        //已经访问过的
        board[i][j] = '#';
        boolean res = dfs(board, i + 1, j, word, index + 1)
                || dfs(board, i - 1, j, word, index + 1)
                || dfs(board, i, j + 1, word, index + 1)
                || dfs(board, i, j - 1, word, index + 1);
        //撤回修改
        board[i][j] = temp;
        return res;
    }
}
