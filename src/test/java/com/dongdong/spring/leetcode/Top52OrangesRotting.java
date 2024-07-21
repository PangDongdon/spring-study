package com.dongdong.spring.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 腐烂的橘子
 */
public class Top52OrangesRotting {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};

    public int orangesRotting(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    map.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int c = code / C, r = code % C;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    map.put(ncode, map.get(ncode) + 1);
                    ans = map.get(ncode) + 1;
                }
            }
        }
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
