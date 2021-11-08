package com.dongdong.spring.test.sort2;

import org.junit.Test;

public class HeapSort {


    public void  test(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
       for(int i=0;i<arr.length;i++){
           heapInsert(arr,i);
       }
       int size=arr.length;
       JavaUtil.swapNum(arr,0,--size);
       while (size>0){
           heapify(arr,0,size);
           JavaUtil.swapNum(arr,0,--size);
       }
       JavaUtil.printNum(arr);
    }

    public void heapInsert(int[] arr,int index){
        while(arr[index]>arr[(index-1)/2]){
             JavaUtil.swapNum(arr,index,(index-1)/2);
             index=(index-1)/2;
        }
    }


    public void heapify(int[] arr,int index,int size){
        int left=index * 2+1;
        while(left<size){
            int largest=left+1<size && arr[left]<arr[left+1]? left+1:left;
             largest=arr[largest]>arr[index] ? largest:index;
             if(largest==index){
                 break;
             }
             JavaUtil.swapNum(arr,largest,index);
             index=largest;
             left=index*2+1;
        }

    }

    @Test
    public void test2(){
        int[] arr=JavaUtil.s;
        test(arr);
    }
}
