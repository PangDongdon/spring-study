package com.dongdong.spring.leetcode;

/**
 * 岛屿问题
 */
public class Top51NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numLand = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    numLand++;
                    dfs(grid, r, c);
                }
            }
        }
        return numLand;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c]='0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}
