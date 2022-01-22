package com.dongdong.spring.test.sort;

public class MinPath {

    private static  int minPath(int[][] matrix){
        return process(matrix,matrix.length-1,matrix[0].length-1);
    }

    private  static  int process(int[][] matrix,int i,int j){
       int res= matrix[i][j];
       if(i==0 && j==0){
           return res;
       }
       if(i==0 && j!=0){
          return  res+process(matrix,i,j-1);
       }
        if(i!=0 && j==0){
            return  res+process(matrix,i-1,j);
        }
        return  res+Math.min(process(matrix,i,j-1),process(matrix,i-1,j));
    }

    private static int  minPath2(int[][] m){
        if(m==null || m.length==0 || m[0]==null || m[0].length==0){
            return 0;
        }
        int row=m.length;
        int col=m[0].length;
        int db[][]=new int[row][col];
        db[0][0]=m[0][0];
        for(int i=1;i<row;i++){
            db[i][0]=db[i-1][0]+m[i][0];
        }
        for(int j=1;j<col;j++){
            db[0][j]=db[0][j-1]+m[0][j];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                db[i][j]=Math.min(db[i][j-1],db[i-1][j])+m[i][j];
            }
        }
        return db[row-1][col-1];
    }

    // for test
    public static int[][] generateRandomMatrix(int rowSize, int colSize) {
        if (rowSize < 0 || colSize < 0) {
            return null;
        }
        int[][] result = new int[rowSize][colSize];
        for (int i = 0; i != result.length; i++) {
            for (int j = 0; j != result[0].length; j++) {
                result[i][j] = (int) (Math.random() * 10);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPath(m));
       /// System.out.println(minPath2(m));

        //m = generateRandomMatrix(6, 7);
       // System.out.println(minPath(m));
        System.out.println(minPath2(m));
    }
}
