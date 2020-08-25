package com.dongdong.spring.test.sort;


/**
 * @Description:  快排
 * @Date: 2020/7/29  11:30
 * @Author: dongdong
 */
public class QuickSort {

//    public static void quickSort(int[] a, int L, int r) {
//        if (L > r) {
//            return;
//        }
//        int i = L;
//        int j = r;
//        int key = a[L]; // 选择第一个数为key
//
//        while (i < j) {
//            while (i < j && a[j] >= key) {  //从右向左找第一个小于key 的值
//                j--;
//            }
//            if (i < j) {
//                a[i] = a[j];
//                i++;
//            }
//
//            while (i < j && a[i] < key) { //从右向左找一个大于key 的值
//                i++;
//            }
//            if (i < j) {
//                a[j] = a[i];
//                j--;
//            }
//        }
//        a[i]=key;
//        quickSort(a,L,i-1);
//        quickSort(a,i+1,r);
//    }

    public static void main(String[] args) {
        int[] a={48,6,57,42,60,72,83,73,88,85};
        quickSort1(a,10);
        for(int ss:a){
            System.out.println(ss);
        }
    }

    public static void quickSort1(int[] a, int n ){
        sort(a,0,n-1);
    }
    public static  void sort(int[] a,int lo,int hi){
        if(lo>=hi) return;
        int i=partition(a,lo,hi);
        sort(a,lo,i);
        sort(a,i+1,hi);
    }
    public static  int  partition(int[] a,int lo,int hi){
        int c=a[lo]; //切分基准
        int i=lo; int j=hi+1; //左右指针扫描
        while(true){
            while(a[--j]>=c){
                if(j==lo) break;
            }
            while(a[++i]<=c){
                if(i==hi) break;
            }
            if(i>=j) break;
            {
                int temp=a[j];a[j]=a[i];a[i]=temp;
            }
        }
        a[lo]=a[j];a[j]=c;
        return j;
    }



    public void sort1(int[] a,int low,int high){

        int start=low;
        int end=high;

        int key=a[low];

        while (end>start){

            //从后往前比较
            while(end>start && a[end]>=key){
                end--;
                if(a[end]<=key){
                    int temp= a[end];
                    a[end]=a[start];
                    a[start]=temp;
                }
            }

            //从前往后比较
            while(end>start && a[start]<=key){
                start++;
                if(a[start]>=key){
                    int temp=a[start];
                    a[start]=a[end];
                    a[end]=temp;
                }
            }

            //递归
            if(start>low){
                sort1(a,low,start-1); //左边序列.第一个索引位置到关键字索引-1
            }
            if(end<high){
                sort1(a,end+1,high); //右边序列.从关键值索引+1到最后一个
            }
        }

    }


}
