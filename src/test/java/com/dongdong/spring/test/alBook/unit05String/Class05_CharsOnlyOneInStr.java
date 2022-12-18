package com.dongdong.spring.test.alBook.unit05String;

/**
 * 判断字符数组中是否所有的字符都出现过一次
 */
public class Class05_CharsOnlyOneInStr {

    public static boolean isUnique1(char[] chars) {
        if (chars == null) {
            return true;
        }
        boolean[] res = new boolean[256];
        for (int i = 0; i < chars.length; i++) {
            if (res[chars[i]]) {
                return false;
            }
            res[chars[i]] = true;
        }
        return true;
    }

    public static boolean isUnique2(char[] chars) {
        if (chars == null) {
            return true;
        }
        heapSort(chars);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                return false;
            }
        }
        return true;
    }


    public static void heapSort(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            heapInsert(chars, i);
        }
        for (int i = chars.length-1; i > 0; i--) {
            swap(chars, 0, i);
            heapify(chars, 0, i);
        }
    }

    public static void swap(char[] chars, int index1, int index2) {
        char tmp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = tmp;
    }

    public static void heapInsert(char[] chars, int i) {
        int parent = 0;
        while (i != 0) {
            parent = (i - 1) / 2;
            if (chars[parent] < chars[i]) {
                swap(chars, parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }

    public static void heapify(char[] chars, int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        while (left < size) {
            if (chars[left] > chars[i]) {
                largest = left;
            }
            if (right < size && chars[right] > chars[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(chars, largest, i);
            } else {
                break;
            }
            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c'};
        char[] chars1 = {'1', '2', '1'};
        System.out.println(isUnique1(chars));
        System.out.println(isUnique1(chars1));
        System.out.println(isUnique2(chars));
        System.out.println(isUnique2(chars1));
    }

}
