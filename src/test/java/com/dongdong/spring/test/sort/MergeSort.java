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


    public static void main(String[] args) {
        int[] a={48,6,57,42,60,72,83,73,88,85};
        mergeSort(a,10);
        for(int s:a){
            System.out.println(s);
        }
    }
}
