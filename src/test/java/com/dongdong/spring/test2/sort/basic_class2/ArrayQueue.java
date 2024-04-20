package com.dongdong.spring.test2.sort.basic_class2;

//使用固定数组实现队列
public class ArrayQueue {
    private int[] arr;
    private int size;
    private int start;
    private int end;

    public ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException();
        }
        arr = new int[initSize];
        start = 0;
        end = 0;
        size = 0;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[start];
    }

    public void push(int num) {
        if (size == arr.length) {
            throw new IllegalArgumentException();
        }
        size++;
        arr[end] = num;
        end = getNextIndex(arr.length, end);
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        size--;
        int tmp = start;
        start = getNextIndex(arr.length, start);
        return arr[tmp];
    }

    private int getNextIndex(int length, int size) {
        return size == length ? 0 : size + 1;
    }
}
