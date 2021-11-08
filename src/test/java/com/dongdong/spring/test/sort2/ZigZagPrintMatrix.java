package com.dongdong.spring.test.sort2;

public class ZigZagPrintMatrix {

  public static void printMatrixZigZag(int[][] arr){
   int tC=0;
   int tR=0;
   int dC=0;
   int dR=0;
   int endC=arr[0].length-1;
   int endR=arr.length-1;
   boolean fromUp=false;
   while(tR!=endR+1){
       printLevel(arr,tC,tR,dC,dR,fromUp);
       tR=tC==endC? tR+1:tR;
       tC=tC==endC? tC:tC+1;
       dC=dR==endR? dC+1:dC;
       dR=dR==endR? dR:dR+1;
       fromUp=!fromUp;
   }
  }

    private static void printLevel(int[][] arr, int tC, int tR, int dC, int dR,boolean f) {
       if(f){
           while(tR!=dR+1){
               System.out.print(arr[tR++][tC--]+" ");
           }
       }else{
           while(dR!=tR-1){
               System.out.print(arr[dR--][dC++]+" ");
           }
       }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
        //1 2 5 9 6 3 4 7 10 11 8 12
    }
}
