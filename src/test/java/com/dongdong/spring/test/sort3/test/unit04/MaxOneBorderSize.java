package com.dongdong.spring.test.sort3.test.unit04;

public class MaxOneBorderSize {


    public static  int getMaxSize(int[][] m){
        if(m==null){
            return  0;
        }
        int[][] right=new int[m.length][m[0].length];
        int[][] down=new int[m.length][m[0].length];
        sortBoderMap(m,right,down);
        for(int size=Math.min(m.length,m[0].length);size>-1;size--){
            if(hasSizeOfBorder(size,right,down)){
                return  size;
            }
        }
        return  0;
    }

    private static boolean hasSizeOfBorder(int size, int[][] right, int[][] down) {
        for(int i=0;i<right.length;i++){
            for(int j=0;j<right[0].length;j++){
                if(right[i][j]>=size && down[i][j]>=size
                        && right[i+size-1][j]>=size && down[i][j+size-1]>=size){
                    return  true;
                }
            }
        }
        return  false;
    }

    private static void sortBoderMap(int[][] m, int[][] right, int[][] down) {
        int r=m.length;
        int c=m[0].length;
        if(m[r-1][c-1]==1){
            right[r-1][c-1]=1;
            down[r-1][c-1]=1;
        }

        for(int i=r-2;i>-1;i--){
            if(m[i][c-1]==1){
                right[i][c-1]=1;
                down[i][c-1]=down[i+1][c-1]+1;
            }
        }

        for(int i=c-2;i>-1;i--){
            if(m[r-1][i]==1){
                down[r-1][i]=1;
                right[r-1][i]=right[i+1][c-1]+1;
            }
        }

        for(int i=r-2;i>-1;i--){
            for(int j=c-2;j>-1;j--){
                if(m[i][j]==1){
                    down[i][j]=down[i+1][j]+1;
                    right[i][j]=right[i][j+1]+1;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 1 ,1},{0 ,1 ,0 },{0, 0 ,1}};
        System.out.println(getMaxSize(matrix));
    }
}
