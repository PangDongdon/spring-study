package com.dongdong.spring.test.alBook.unit04Recursion;

/**
 * 字符串的交错组成
 */
public class Class14_StrMixComposition {

    public static boolean isCross1(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null) {
            return false;
        }
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] aimC = aim.toCharArray();
        if(chars1.length+chars2.length!=aimC.length){
            return  false;
        }
        boolean[][] dp = new boolean[chars1.length + 1][chars2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= chars1.length; i++) {
            if (chars1[i - 1] != aimC[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j <= chars2.length; j++) {
            if (chars2[j - 1] != aimC[j - 1]) {
                break;
            }
            dp[0][j] = true;
        }
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if ((dp[i - 1][j] && chars1[i - 1] == aimC[i - 1 + j])
                        || (dp[i][j - 1] && chars2[j - 1] == aimC[i + j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[chars1.length][chars2.length];
    }

    public static void main(String[] args) {
        String str1="AB";
        String str2="12";
        String aim="AB12";
        System.out.println(isCross1(str1,str2,aim));
    }
}
