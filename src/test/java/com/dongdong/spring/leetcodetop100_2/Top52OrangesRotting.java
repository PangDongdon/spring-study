package com.dongdong.spring.leetcodetop100_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的橘子
 */
public class Top52OrangesRotting {

    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                final int[] poll = queue.poll();
                int m = poll[0];
                int n = poll[1];

                if (m - 1 >= 0 && grid[m - 1][n] == 1) {
                    grid[m - 1][n] = 2;
                    count--;
                    queue.add(new int[]{m - 1, n});
                }

                if (m + 1 < M && grid[m + 1][n] == 1) {
                    grid[m + 1][n] = 2;
                    count--;
                    queue.add(new int[]{m + 1, n});
                }

                if (n - 1 >= 0 && grid[m][n - 1] == 1) {
                    grid[m][n - 1] = 2;
                    count--;
                    queue.add(new int[]{m, n - 1});
                }

                if (n + 1 < N && grid[m][n + 1] == 1) {
                    grid[m][n + 1] = 2;
                    count--;
                    queue.add(new int[]{m, n + 1});
                }

            }
        }
        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
}
