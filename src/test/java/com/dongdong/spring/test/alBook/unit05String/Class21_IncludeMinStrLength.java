package com.dongdong.spring.test.alBook.unit05String;

/**
 * 最小包含子串的长度
 */
public class Class21_IncludeMinStrLength {

    public static int minLength(String str1, String str2) {
        if (str1 == null || "".equals(str1) || str2 == null || "".equals(str2)
                || str1.length() < str2.length()) {
            return 0;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i != chars2.length; i++) {
            map[chars2[i]]++;
        }
        int left = 0;
        int right = 0;
        int match = chars2.length;
        int minLength = Integer.MAX_VALUE;
        while (right != chars1.length) {
            map[chars1[right]]--;
            if (map[chars1[right]] >= 0) {
                match--;
            }
            if (match == 0) {
                while (map[chars1[left]] < 0) {
                    map[chars1[left++]]++;
                }
                minLength = Math.min(minLength, right - left + 1);
                match++;
                map[chars1[left++]]++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        String str1 = "adabbca";
        String str2 = "acb";
        System.out.println(minLength(str1, str2));
    }

}
