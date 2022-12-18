package com.dongdong.spring.test.alBook.unit05String;

/**
 * 判断两个字符串是否为变形词
 */
public class Class01_TwoStrIsDeformation {
    public static boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] arr = new int[256];
        for (int i = 0; i < chars1.length; i++) {
            arr[chars1[i]]++;
        }
        for (int j = 0; j < chars2.length; j++) {
            if (arr[chars2[j]]-- == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "adv";
        String str2 = "dav";
        System.out.println(isDeformation(str1, str2));
    }
}
