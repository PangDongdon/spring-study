package com.dongdong.spring.test.sort5.study.unit07;

public class Code07_DungeonGame {

    public static int minHP1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 1;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row--][col--];
        dp[row][col] = m[row][col] > 0 ? 1 : 1 - m[row][col];
        for(int j=col-1;j>-1;j--){
            dp[row][j]=Math.max(dp[row][j+1]-m[row][j],1);
        }
        int right=0;
        int down=0;
        for(int i=row-1;i>-1;i--){
            dp[i][col]=Math.max(dp[i+1][col]-m[i][col],1);
            for(int j=col-1;j>-1;j--){
                down=Math.max(dp[i+1][j]-m[i][j],1);
                right=Math.max(dp[i][j+1]-m[i][j],1);
                dp[i][j]=Math.min(right,down);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] map = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 }, };
        System.out.println(minHP1(map));
    }
}
