package com.dongdong.spring.test.sort.test.unit03;

public class PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] arr) {
        if (arr == null || arr[0] == null) {
            return;
        }
        int col1 = 0;
        int row1 = 0;
        int col2 = arr.length - 1;
        int row2 = arr[0].length - 1;
        while (col1 <= col2 && row1 <= row2) {
            printEdage(arr, col1++, row1++, col2--, row2--);
        }
    }

    public static void printEdage(int[][] arr, int clo1, int row1, int col2, int row2) {
        if (clo1 == col2) {
            for (int i = row1; i <= row2; i++) {
                System.out.print(arr[clo1][i] + " ");
            }
        } else if (row1 == row2) {
            for (int i = clo1; i <= col2; i++) {
                System.out.print(arr[i][row1] + " ");
            }
        } else {
            int curC = clo1;
            int curR = row1;
            while (curR < row2) {
                System.out.print(arr[clo1][curR] + " ");
                curR++;
            }
            while (curC < col2) {
                System.out.print(arr[curC][row2] + " ");
                curC++;
            }
            while (curR > row1) {
                System.out.print(arr[col2][curR] + " ");
                curR--;
            }

            while (curC > clo1) {
                System.out.print(arr[curC][row1] + " ");
                curC--;
            }
        }
    }

    public static void main(String[] args) {
        // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);
    }
}
