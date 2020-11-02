package com.dongdong.spring.test.sort;

/**
 * @Description: 堆排序
 * @Date: 2020/10/19  16:52
 * @Author: dongdong
 */
public class HeapSort {

   public  static  void maxHeap(int[] arr,int size,int index){
       //左子结点
       int leftNode=2*index+1;
       //右子结点
       int rightNode=2*index+2;
       int max=index;
       //和两个子结点分别对比，找出最大的结点
       if(leftNode<size && arr[leftNode]>arr[max]){
           max=leftNode;
       }
       if(rightNode<size && arr[rightNode]>arr[max]){
           max=rightNode;
       }
       //交换位置
       if(max!=index){
           int temp=arr[index];
           arr[index]=arr[max];
           arr[max]=temp;
           //因为交换位置后可能使子树不满足大顶堆条件，所以要对子树进行调整
           maxHeap(arr,size,max);
       }
   }


   public static void heapSort(int[] arr){
       //开始位置是最后一个非叶子结点，即最后一个节点的父节点
       int start=(arr.length-1)/2;
       //调整为大顶堆
       for(int i=start;i>=0;i--){
           maxHeap(arr,arr.length,i);
       }
       //先把数组中的第0个位置和堆中最后一个数交换位置，再把前面的处理为最大顶堆
       for(int i=arr.length-1;i>0;i--){
           int temp=arr[0];
           arr[0]=arr[i];
           arr[i]=temp;
           maxHeap(arr,i,0);
       }

   }



}
