package com.dongdong.spring.leetcodetop100_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 */
public class Top52OrangesRotting {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] code = queue.poll();
                int r = code[0];
                int c = code[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    queue.offer(new int[]{r - 1, c});
                    count--;
                }
                if (r + 1 < nr && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    queue.offer(new int[]{r + 1, c});
                    count--;
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    queue.offer(new int[]{r, c - 1});
                    count--;
                }

                if (c + 1 < nc && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    queue.offer(new int[]{r, c + 1});
                    count--;
                }

            }
        }
        return count == 0 ? round : -1;
    }
}
