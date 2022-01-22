package com.dongdong.spring.test.sort;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MadianQuick {

    public static class MedianHolder {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeadComparator());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeadComparator());

        //大堆小堆数量均衡
        private void modifyTwoHeapsSize() {
            if (maxHeap.size() == minHeap.size() + 2) {
                minHeap.add(maxHeap.poll());
            }
            if (minHeap.size() == maxHeap.size() + 2) {
                maxHeap.add(minHeap.poll());
            }
        }

        //往堆中加值
        private void addNumber(int number){
            if(maxHeap.isEmpty()){
                maxHeap.add(number);
                return;
            }
            if(maxHeap.peek()>=number){
                maxHeap.add(number);
            }else{
                if(minHeap.isEmpty()){
                   minHeap.add(number);
                   return;
                }
                if(minHeap.peek()>number){
                    maxHeap.add(number);
                }else{
                    minHeap.add(number);
                }
            }
            modifyTwoHeapsSize();
        }

        //获取中值
        private Integer getMedian() {
            int maxHeapSize = maxHeap.size();
            int minHeapSize = minHeap.size();
            if (maxHeapSize + minHeapSize == 0) {
                return null;
            }
            Integer maxHeapValue=maxHeap.peek();
            Integer minHeapValue=minHeap.peek();
            if (((maxHeapSize + minHeapSize) & 1) == 0) {
                return (maxHeapValue+minHeapValue)/2;
            }
            return maxHeapSize>minHeapSize ? maxHeapValue:minHeapValue;
        }

    }


    //定义大堆比较器
    public static class MaxHeadComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    //定义小堆比较器
    public static class MinHeadComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }



    // for test
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = getRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNumber(arr[j]);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }
}
