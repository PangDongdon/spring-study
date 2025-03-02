package com.dongdong.spring.leetcodetop100_2;

/**
 * 岛屿的数量
 */
public class Top51NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid[0] == null) {
            return 0;
        }
        int landNums = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    landNums++;
                    dfs(grid, r, c);
                }
            }
        }
        return landNums;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
