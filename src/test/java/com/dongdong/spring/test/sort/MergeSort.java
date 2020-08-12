package com.dongdong.spring.test.sort;

/**
 * @Description: 归并排序 ：保持有序的合并
 * @Date: 2020/7/29  14:41
 * @Author: dongdong
 */
public class MergeSort {
    private static int[] aux=new int[10];
    public static void sort(int [] a,int lo,int hi){
        if(lo>=hi) return;
        int mid=(lo+hi)/2;
        sort(a,lo,mid); //左半部排序
        sort(a,mid+1,hi); //右半部排序
        merge(a,lo,mid,hi);
    }

    //原地归并排序
    private static void merge(int[] a, int lo, int mid, int hi) {
        //将数组a中的元素复制到aux 中
        for(int i=lo;i<=hi;i++){
            aux[i]=a[i];
        }
        //归并
        int i=lo;
        int j=mid+1;
        for(int k=lo;k<=hi;k++){
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(aux[j]<aux[i]) a[k]=aux[j++];
            else a[k]=aux[i++];
        }
    }

    public static  void mergeSort(int[] a,int n){
        aux=new int[n];
        sort(a,0,n-1);
    }

    //
    public  static  void mergeSort2(int [] a,int n){
        //进行logn次两两归并
        aux=new int[n];
        //size 是子数组的长度，lo 是子数组的索引（即是第一个元素）
        for(int size=1;size<n;size=size*2){
            for(int lo=0;lo<n-size;lo+=size+size){
                merge(a,lo,lo+size-1,Math.max(lo+size+size-1,n-1));
            }
        }
    }


//    public static void main(String[] args) {
//        int[] a={48,6,57,42,60,72,83,73,88,85};
//        mergeSort(a,10);
//        for(int s:a){
//            System.out.println(s);
//        }
//    }
   /**22*/


   public static void main(String[] args) {
       int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 };
       print(data);
       mergeSort(data);
       System.out.println("排序后的数组：");
       print(data);
   }

    public static void mergeSort(int[] data) {
        sort1(data, 0, data.length - 1);
    }

    public static void merge1(int[] data,int left,int center,int right) {
       //定义临时数组
        int[] temArr = new int[data.length];
       //右边数组第一个元素索引
        int mid = center + 1;
       //third 记录临时数组的索引
        int third = left;
       //缓存左数组第一个元素的索引
        int temp = left;

        while (left <= center && mid <= right) {
            //两个数组最小去除放入临时数组
            if (data[left] <= data[mid]) {
                temArr[third++] = data[left++];
            } else {
                temArr[third++] = data[mid++];
            }
        }
         //剩余部分依次放入临时数组
        while (mid <= right) {
            temArr[third++] = data[mid++];
        }
        while (left <= center) {
            temArr[third++] = data[left++];
        }
       //临时数组中的内容拷贝到原数组中
        while (temp <= right) {
            data[temp] = temArr[temp++];
        }

    }


    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

    public static void sort1(int[] data,int left,int right){
        if(left>=right){
            return;
        }
        //找出中间索引
        int  center=(left+right)/2;
        //对左边数组进行递归
        sort1(data,left,center);
        //对右边数组进行递归
        sort1(data,center+1,right);
        //合并
        merge1(data,left,center,right);
        print(data);
    }

}
