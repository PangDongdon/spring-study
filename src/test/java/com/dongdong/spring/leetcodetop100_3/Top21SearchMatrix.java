package com.dongdong.spring.leetcodetop100_3;
/**
 *搜索二维矩阵II
 */
public class Top21SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
      if(matrix == null){
          return false;
      }
      int m=0;
      int n=matrix[0].length-1;
      while(m<matrix.length && n>=0){
          if(matrix[m][n]>target){
              n--;
          }else if(matrix[m][n]<target){
              m++;
          }else{
              return true;
          }
      }
      return false;
    }
}
