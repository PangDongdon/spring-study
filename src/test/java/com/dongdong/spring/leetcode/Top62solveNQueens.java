package com.dongdong.spring.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *N皇后
 */
public class Top62solveNQueens {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
      char[][] dashboard=new char[n][n];
      for(char[] c:dashboard){
          Arrays.fill(c,'.');
      }
      backtracking(dashboard,n,0);
      return res;
    }

    private void backtracking(char[][] dashboard, int n, int row) {
     if(n==row){
         res.add(ArrayToList(dashboard));
         return;
     }
     for(int col=0;col<n;col++){
         if(isValid(dashboard,col,row,n)){
             dashboard[row][col]='Q';
             backtracking(dashboard,n,row+1);
             dashboard[row][col]='.';
         }
     }
    }

    private boolean isValid(char[][] dashboard, int col, int row,int n) {
      for(int i=0;i<n;i++){
          if(dashboard[i][col]=='Q'){
              return false;
          }
      }
      for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
          if(dashboard[i][j]=='Q'){
              return false;
          }
      }

        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(dashboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    private List<String> ArrayToList(char[][] dashboard) {
        List<String> list=new ArrayList<>();
        for(char[] c:dashboard){
           list.add(String.copyValueOf(c));
        }
        return list;
    }
}
