package com.dongdong.spring.test.sort2;

/**
 * 在时间复杂度n+m 中找到 给定的数 K
 *
 */
public class FindNumInSortedMatrix {

    public static boolean   getNum(int[][] arr,int k){
        if(arr==null || arr.length<1){
            return false;
        }
        int row=0;
        int col=arr[0].length-1;
        while (col>-1 && row<arr.length) {
            if (arr[row][col] < k) {
                row++;
            } else if (arr[row][col] > k) {
                col--;
            }else{
                return true;
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(getNum(matrix, K));
    }
}
