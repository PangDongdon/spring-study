package com.dongdong.spring.test.sort.test.unit02;

public class BFPRT {

    // O(N*logK)
    public static int[] getMinKNumsByHeap(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return null;
        }
        int[] res = new int[k];
        for (int i = 0; i != k; i++) {
            heapInsert(res, arr[i], i);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < res[0]) {
                res[0] = arr[i];
                heapify(res, 0, k);
            }
        }
        return res;
    }

    private static void heapify(int[] res, int index, int heapSize) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        while (left < heapSize) {
            if (res[index] < res[left]) {
                largest = left;
            }
            if (right < heapSize && res[largest] < res[right]) {
                largest = right;
            }
            if (index != largest) {
                swap(res, index, largest);
            } else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }

    }

    private static void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (arr[index] > arr[parent]) {
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // O(N)
    public static int[] getMinKNumsByBFPRT(int[] arr, int k) {
        if (arr == null || arr.length < 1 || arr.length < k) {
            return arr;
        }
        //获取第 k 个小的值
        int minKth = getMinKthByBFPRT(arr, k);
        int[] res = new int[k];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minKth) {
                res[index++] = arr[i];
            }
        }
        for (; index < res.length; index++) {
            res[index] = minKth;
        }
        return res;
    }

    private static int getMinKthByBFPRT(int[] arr, int k) {
        //获取copy 数组
        int[] copyArr = getCopyArray(arr);
        return select(copyArr, 0, copyArr.length - 1, k - 1);
    }

    private static int select(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        //寻找划分值
        int pivot = medianOfMedians(arr, begin, end);
        //
        int[] pivotRange = partition(arr, begin, end, pivot);
        if (i >= pivotRange[0] && i <= pivotRange[1]) {
            return arr[i];
        } else if (i < pivotRange[0]) {
            return select(arr, 0, pivotRange[0] - 1, i);
        } else {
            return select(arr, pivotRange[1] + 1, end, i);
        }
    }


    public static int[] partition(int[] arr, int begin, int end, int pivotValue) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivotValue) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivotValue) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

    private static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return select(mArr, 0, mArr.length - 1, (mArr.length) / 2);
    }


    public static int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = begin + end;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }



    private static void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i <= end; i++) {
            for (int j = i; j != begin; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }


    private static int[] getCopyArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
    }


    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
       // printArray(getMinKNumsByHeap(arr, 10)); //5 3 2 3 1 1 2 2 1 1
        printArray(getMinKNumsByBFPRT(arr, 10));
    }

}



