package com.dongdong.spring.test.sort5.study.unit02;

import org.apache.commons.lang.StringUtils;

public class Code06_StringCross {

    public static boolean isCross(String str1, String str2, String aim) {
        if (StringUtils.isBlank(str1) || StringUtils.isBlank(str2) || StringUtils.isBlank(aim)) {
            return false;
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        char[] charAim = aim.toCharArray();
        int len1 = char1.length;
        int len2 = char2.length;
        if (len1 + len2 != charAim.length) {
            return false;
        }
        boolean[][] isAim = new boolean[len1 + 1][len2 + 1];
        isAim[0][0]=true;
        for (int i = 1; i <= len1; i++) {
            if (char1[i - 1] != charAim[i - 1]) {
                break;
            }
            isAim[i][0] = true;
        }

        for (int j = 1; j <= len2; j++) {
            if (char2[j - 1] != charAim[j - 1]) {
                break;
            }
            isAim[0][j] = true;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if ((char1[i - 1] == charAim[i + j - 1] && isAim[i - 1][j]) ||
                        (char2[j - 1] == charAim[i + j - 1] && isAim[i][j - 1])
                ) {
                    isAim[i][j] = true;
                }
            }
        }
        return isAim[len1][len2];
    }

    public static void main(String[] args) {
        String str1 = "1234";
        String str2 = "abcd";
        String aim = "1a23bcd4";
        System.out.println(isCross(str1, str2, aim));
        System.out.println(isCross(str1, str2, aim));
    }
}
