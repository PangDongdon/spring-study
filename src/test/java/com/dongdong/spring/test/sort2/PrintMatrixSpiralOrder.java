package com.dongdong.spring.test.sort2;

import net.dongliu.commons.Sys;

public class PrintMatrixSpiralOrder {

    public static void  spiralOrderPrint(int[][] arr){
        int tR=0;
        int tC=0;
        int dR=arr.length-1;
        int dC=arr[0].length-1;
        while(tR<=dR && tC<=dC){
            printEdge(arr,tR++,tC++,dR--,dC--);
        }
    }

    private static void printEdge(int[][] arr, int tR, int tC, int dR, int dC) {

        if(tR==dR) { //行数相等
            for (int i = tC; i <= dC; i++) {
                System.out.print(arr[tR][i] +" ");
            }
        }else if(tC==dC){//列数相等
            for(int i=tR;i<=dR;i++){
                System.out.print(arr[i][tC]+" ");
            }
        }else{
         int curTC=tC;
         int curTR=tR;
         while(curTC!=dC){
             System.out.print(arr[tR][curTC]+" ");
             curTC++;
         }

         while(curTR!=dR){
             System.out.print(arr[curTR][dC]+" ");
             curTR++;
            }
         while(curTC!=tC){
             System.out.print(arr[dR][curTC]+" ");
             curTC--;
            }

            while(curTR!=tR){
                System.out.print(arr[curTR][tC]+" ");
                curTR--;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);
        // 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
    }

}
