package com.dongdong.spring.test.sort;

import org.springframework.security.core.parameters.P;

/**
 * @Description:
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

}
