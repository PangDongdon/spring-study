package com.dongdong.spring.test.sort.test.unit02;

import org.apache.logging.log4j.util.Strings;

public class KMP {

    public static int getIndexOf(String s1, String s2) {
        if (Strings.isBlank(s1) || Strings.isBlank(s2) || s2.length() < 1 || s1.length() < s2.length()) {
            return -1;
        }
        char[] c1 = s1.toCharArray();
        int length1 = c1.length;
        char[] c2 = s2.toCharArray();
        int length2 = c2.length;
        int[] next = getNextArray(c2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < length1 && i2 < length2) {
            if (c1[i1] == c2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == length2 ? i1 - i2 : -1;
    }

    //
    public static int[] getNextArray(char[] arr) {
        if (arr == null || arr.length < 3) {
            return new int[]{-1};
        }
        int[] next = new int[arr.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < arr.length) {
            if (arr[pos - 1] == arr[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));

    }

}
