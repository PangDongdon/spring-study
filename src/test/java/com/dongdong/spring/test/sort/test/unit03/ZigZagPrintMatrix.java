package com.dongdong.spring.test.sort.test.unit03;

public class ZigZagPrintMatrix {

    public static void printMatrix(int[][] arr) {
        if (arr == null || arr[0] == null) {
            return;
        }
        int row1 = 0;
        int row2 = 0;
        int clo1 = 0;
        int clo2 = 0;
        int rowEnd = arr.length - 1;
        int colEnd = arr[0].length - 1;
        boolean fromUp = false;
        while (row1 != rowEnd + 1) {
            printLevel(arr, row1, clo1, row2, clo2, fromUp);
            row1 = clo1 == colEnd ? row1 + 1 : row1;
            clo1 = clo1 == colEnd ? clo1 : clo1 + 1;
            clo2 = row2 == rowEnd ? clo2 + 1 : clo2;
            row2 = row2 == rowEnd ? row2 : row2 + 1;
            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] arr, int row1, int col1, int row2, int col2, boolean fromUp) {
        if (fromUp) {
            while (row1 != row2+1) {
                System.out.print(arr[row1++][col1--] + " ");
            }
        } else {
            while (row1 != row2+1) {
                System.out.print(arr[row2--][col2++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        //1 2 5 9 6 3 4 7 10 11 8 12
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMatrix(matrix);
    }

}
