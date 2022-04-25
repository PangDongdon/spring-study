package com.dongdong.spring.test.sort3.test.unit04;

import lombok.Data;
import net.dongliu.commons.Sys;

public class PrintMaxTopK {


    @Data
    public static class HeapNode {
        private int value;
        private int arrNum;
        private int index;

        public HeapNode(int value, int arrNum, int index) {
            this.arrNum = arrNum;
            this.index = index;
            this.value = value;
        }
    }

    public static void printTopK(int[][] matrix, int topK) {
        if (matrix == null || topK < 1) {
            return;
        }
        int heapSize = matrix.length;
        HeapNode[] heapNodes = new HeapNode[heapSize];
        //初始化堆数据
        for (int i = 0; i < heapSize; i++) {
            int index = matrix[i].length-1;
            heapNodes[i] = new HeapNode(matrix[i][index], i, index);
            heapInsert(heapNodes,i);
        }
        System.out.println("TOPK:" + topK);
        for (int i = 0; i < topK; i++) {
            if(heapSize==0){
                return;
            }
            int value = heapNodes[0].value;
            System.out.println(value+" ");
            if(heapNodes[0].index!=0){
                heapNodes[0].value=matrix[heapNodes[0].arrNum][--heapNodes[0].index];
            }else {
                swap(heapNodes,0,--heapSize);
            }
            heapify(heapNodes,0,heapSize);
        }


    }

    public static void heapInsert(HeapNode[] heapNodes, int index) {
        if (heapNodes == null) {
            return;
        }
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heapNodes[index].value > heapNodes[parent].value) {
                swap(heapNodes, index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private static void swap(HeapNode[] heapNodes, int index, int parent) {
        HeapNode temp = heapNodes[index];
        heapNodes[index] = heapNodes[parent];
        heapNodes[parent] = temp;
    }

    public static void heapify(HeapNode[] heapNodes, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (heapNodes[left].value > heapNodes[index].value) {
                largest = left;
            }
            if (right < heapSize && heapNodes[right].value > heapNodes[largest].value) {
                largest = right;
            }
            if (index != largest) {
                swap(heapNodes, index, largest);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    // 56 86
    //71 95
    //24 39
    //===========================
    //TOP 100 :
    //95 86 71 56 39 24
    //Process finished with exit code 0

    public static void main(String[] args) {
        int[][] matrix ={{56,86},{71,95},{24,39}};
        System.out.println("===========================");
        printTopK(matrix, 100);
    }
}
