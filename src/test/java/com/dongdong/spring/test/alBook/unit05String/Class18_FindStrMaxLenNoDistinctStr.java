package com.dongdong.spring.test.alBook.unit05String;

/**
 * 找到字符串的最长无重复字符子串
 */
public class Class18_FindStrMaxLenNoDistinctStr {

    public static int maxUnique(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i != chars.length; i++) {
            pre = Math.max(pre, map[chars[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[chars[i]] = i;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(maxUnique(s));
    }

}
