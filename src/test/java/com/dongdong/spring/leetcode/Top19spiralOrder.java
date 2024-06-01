package com.dongdong.spring.leetcode;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.ArrayList;
import java.util.List;

public class Top19spiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int tr = 0;
        int tc = 0;
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;
        while (tr <= dr && tc <= dc) {
            printEdge(matrix, tr++, tc++, dr--, dc--);
        }
        return res;
    }

    private static void printEdge(int[][] matrix, int tr, int tc, int dr, int dc) {
        if (tr == dr) {
            for (int i = tc; i <= dc; i++) {
                System.out.print(matrix[tr][i] + " ");
            }
        } else if (tc == dc) {
            for (int i = tr; i <= dr; i++) {
                System.out.print(matrix[i][dc] + " ");
            }
        } else {
            int curR = tr;
            int curC = tc;
            while (curC != dc) {
                System.out.print(matrix[tr][curC] + " ");
                curC++;
            }

            while (curR != dr) {
                System.out.print(matrix[curR][dc] + " ");
                curR++;
            }

            while (curC != tc) {
                System.out.print(matrix[dr][curC] + " ");
                curC--;
            }

            while (curR != tr) {
                System.out.print(matrix[curR][tc] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrder(matrix);

    }
}
