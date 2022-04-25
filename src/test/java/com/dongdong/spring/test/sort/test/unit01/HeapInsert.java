package com.dongdong.spring.test.sort.test.unit01;

import com.dongdong.spring.test.sort.test.util.Utils;

public class HeapInsert {

    public static  void sort(int[] arr){
        if(arr==null){
            return;
        }
        int heapSize=arr.length;
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        Utils.swap(arr,0,--heapSize);
        while(heapSize>0){
            heapfity(arr,0,heapSize);
            Utils.swap(arr,0,--heapSize);
        }
        Utils.printArr(arr);
    }

    public static  void heapInsert(int[] arr,int index){
            while(arr[index]>arr[(index-1)/2]){
                Utils.swap(arr,index,(index-1)/2);
                index=(index-1)/2;
            }
    }

    public static  void heapfity(int[] arr,int index,int heapSize){
        int left=index*2+1;
        while(left<heapSize){
            int largest=left+1<heapSize && arr[left+1]>arr[left]?left+1:left;
            largest=arr[largest]>arr[index]? largest:index;
            if(largest==index){
                break;
            }
            Utils.swap(arr,largest,index);
            index=largest;
            left=index*2+1;
        }
    }

    public static void main(String[] args) {
        int[] arr=Utils.arr;
        sort(arr);
    }
}
