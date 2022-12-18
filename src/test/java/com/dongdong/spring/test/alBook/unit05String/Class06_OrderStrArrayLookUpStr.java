package com.dongdong.spring.test.alBook.unit05String;

/**
 * 在有序但含有空的数组中查找字符串
 */
public class Class06_OrderStrArrayLookUpStr {

    public static int getIndex(String[] strs, String str) {
        if (strs == null || strs.length < 1 || str == null) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = strs.length - 1;
        int mid = 0;
        int i = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (strs[mid] != null && strs[mid].equals(str)) {
                res = mid;
                right = mid - 1;
            } else if (strs[mid] != null) {
                if (strs[mid].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                i = mid;
                while (strs[i] == null && --i >= left) ;
                if (i < left || strs[i].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    res = strs[i].equals(str) ? i : res;
                    right = i - 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {null, "a", null, "b", null, "c"};
        System.out.println(getIndex(strs, "a"));
        System.out.println(getIndex(strs, null));
        System.out.println(getIndex(strs, "d"));
    }
}
