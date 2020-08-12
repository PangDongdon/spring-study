package com.dongdong.spring.test.sort;
/**
 * 希尔排序
 *
 * */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr={1,2,5,3};
         int temp=0;
         int incre=arr.length;

         while(true){
             incre=incre/2;
             for(int k=0;k<incre;k++){//根据增量分为若干子序列
                 for(int i=k+incre;i<arr.length;i+=incre){
                     for(int j=i;j>k;j-=incre) {
                         if (arr[j] < arr[j - incre]) {
                             temp = arr[j - incre];
                             arr[j - incre] = arr[j];
                             arr[j] = temp;
                         } else {
                             break;
                         }
                     }
                 }
             }
         }
    }


     //2.希尔排序
    public  static void shellSort(int[] a,int n){
       int h=1;
       while(h<n/3){
           h=3*h+1;
       }
       while(h>=1){
           for(int i=0;i<n;i++){
             for(int j=i;j>=h && a[j]<a[j-h];j=j-h){
                 int temp=a[j];a[j]=a[j-h];a[j-h]=temp;// 交换元素
             }
           }
           h=h/3;//减少间距
       }
    }

     private void shellSort(int[] a){
       int dk=a.length/2;
       while(dk>=1){
           ShellInsertSort(a,dk);
           dk=dk/2;
       }
     }

     private void  ShellInsertSort(int[] a,int dk){
         //类似插入排序，插入排序的增量是1，这里的增量是dk
         for(int i=dk;i<a.length;i++){
             if(a[i]<a[i-dk]){
               int j;
               int x=a[i]; //x为待插入元素
               a[i]=a[i-dk];
               for(j=i-dk;j>=0 && x<=a[j];j=j-dk){
                   //通过循环，逐个后移一位要找到要插入的位置
                   a[j+dk]=a[j];
               }
               a[j+dk]=x;
             }
         }
     }
}
