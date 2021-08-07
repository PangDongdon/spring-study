package com.dongdong.spring.test.leetCode.linkedList;

/**
 * @Description: 托普利茨矩阵
 * @Date: 2020/12/15  16:16
 * @Author: dongdong
 */
public class Sort766 {
    //1 2 3 4
    //5 1 2 3
    //9 5 1 2


    //1,2
    //2,2
    public boolean  checkTpulicimMatrix(int[][] matrix){
        int m=matrix.length; //3
        int n=matrix[0].length;//4
        int i=0;
        int j=0;
        int sameVal=matrix[i][j];
        while(++i<m && ++j<n){
            if(matrix[i][j]!=sameVal){
                return  false;
            }
        }
        for(i=1,j=0;i<m;i++){
            int tmpi=i;
            int tmpj=j;
            sameVal=matrix[i][j]; //2,3,4
            while(++i<tmpi && ++j<tmpj){//2,1  3,2
                if(matrix[tmpi][tmpj]!=sameVal){
                    return  false;
                }
            }
        }
         for(i=0,j=1;j<n;j++){
             int tmpj=j;
             int tmpi=i;
             sameVal=matrix[tmpi][tmpj];
             while(++tmpi<m && ++tmpj<n){
                 if(matrix[tmpi][tmpj]!=sameVal){
                     return  false;
                 }
             }
         }
        return  true;
    }
}
