package com.dongdong.spring.test2.sort;

/**
 * @Description:
 * @Date: 2021/2/4  17:47
 * @Author: dongdong
 */
public class HeapSort {
  static int  heapLen;


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] HeapSort(int[] arr){
        //index at end of heap
        heapLen=arr.length;
        //build MaxHeap
        buildMaxHeap(arr);
        for(int i=arr.length-1;i>0;i--){
            //Move the top of the heap to the tail of the heap in turn
            swap(arr,0,i);
            heapLen-=1;
            heapify(arr,0);
        }
       return arr;
    }

    //build Max Heap
    private static void buildMaxHeap(int[] arr){
        for(int i=arr.length/2-1;i>=0;i--){
            heapify(arr,i);
        }
    }

    //Adjust it to maximum heap
    private static void heapify(int[] arr,int i){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;

        if(right<heapLen  && arr[right]>arr[largest]){
            largest=right;
        }
        if(left<heapLen && arr[left]>arr[largest]){
            largest=left;
        }
        if(largest!=i){
            swap(arr,largest,i);
            heapify(arr,largest);
        }
    }


}
