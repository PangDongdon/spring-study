package com.dongdong.spring.test.sort3.test.unit01;

public class Find_the_Closest_Palindrome {

    public static String nearestPalindromic(String n) {
        Long num = Long.parseLong(n);
        Long raw = getRawPalindrome(n);
        Long smallRaw = raw < num ? num : getSmallPalindrome(num);
        Long bigRaw = raw > num ? raw : getBigPalindrome(num);
        return bigRaw - num > num - smallRaw ? String.valueOf(smallRaw) : String.valueOf(bigRaw);
    }

    public static Long getRawPalindrome(String n) {
        char[] chs = n.toCharArray();
        for (int i = 0; i < chs.length / 2; i++) {
            chs[chs.length - 1 - i] = chs[i];
        }
        return Long.parseLong(String.valueOf(chs));
    }


    public static Long getSmallPalindrome(Long raw) {
        char[] chars = String.valueOf(raw).toCharArray();
        char[] res = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            res[i] = chars[i];
        }
        int size = res.length;
        for (int i = (size - 1) / 2; i >= 0; i--) {
            if (--res[i] < '0') {
                res[i] = '9';
            } else {
                break;
            }
        }
        if (res[0] == '0') {
            res = new char[size - 1];
            for (int i = 0; i < res.length; i--) {
                res[i] = '9';
            }
        }
        for (int k = 0; k < size / 2; k++) {
            res[size - k - 1] = res[k];
        }
        return Long.parseLong(String.valueOf(res));
    }

    public static Long getBigPalindrome(Long raw) {
        char[] chars = String.valueOf(raw).toCharArray();
        char[] res = new char[chars.length + 1];
        res[0] = '0';
        for (int i = 0; i < chars.length; i++) {
            res[i + 1] = chars[i];
        }
        int size = chars.length;
        for (int i = (size - 1) / 2 + 1; i >= 0; i--) {
            if (++res[i] > '9') {
                res[i] = '0';
            } else {
                break;
            }
            return size == 1 ? 0 : Long.parseLong(String.valueOf(res));
        }
        size = res.length;
        int offset = res[0] == '1' ? 1 : 0;
        for (int i = size - 1; i >= (size + offset) / 2; i--) {
            res[i] = res[size - offset - i];
        }
        return Long.parseLong(String.valueOf(res));
    }
}
