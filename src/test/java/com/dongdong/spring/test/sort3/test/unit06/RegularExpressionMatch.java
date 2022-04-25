package com.dongdong.spring.test.sort3.test.unit06;

public class RegularExpressionMatch {

    private static boolean isValid(char[] s, char[] e) {
        if (s == null || e == null) {
            return false;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '.' || s[i] == '*') {
                return false;
            }
        }
        for (int i = 0; i < e.length; i++) {
            if (e[i] == '*' && (i == 0 || e[i -1] == '*')) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMatch(String s, String e) {
        if (s == null || e == null) {
            return false;
        }
        char[] si = s.toCharArray();
        char[] ej = e.toCharArray();
        return isValid(si, ej) ? process(si, ej, 0, 0):false;
    }

    private static boolean process(char[] si, char[] ej, int i, int j) {
        if (j == ej.length) {
            return i == si.length;
        }
        if (j + 1 == ej.length || ej[j + 1] != '*') {
            return i != si.length && (si[i] == ej[j] || ej[j] == '.') && process(si, ej, i + 1, j + 1);
        }
        while (i != si.length && (si[i] == ej[j] || ej[j] == '.')) {
            if (process(si, ej, i, j + 2)) {
                return true;
            }
            i++;
        }
        return process(si, ej, i, j + 2);
    }

    public static void main(String[] args) {
        String str = "abcccdefg";
        String exp = "ab.*d.*e.*";
        System.out.println(isMatch(str, exp));
        System.out.println(isMathDP(str, exp));

    }

    public static  boolean isMathDP(String s,String e){
        if(s==null ||e==null){
            return  false;
        }
        char[] si=s.toCharArray();
        char[] ej=e.toCharArray();
        if(!isValid(si,ej)){
            return false;
        }
        boolean[][] dp=initDP(si,ej);
        for(int i=si.length-1;i>-1;i--){
            for(int j=ej.length-2;j>-1;j--){
                if(ej[j+1]!='*'){
                    dp[i][j]=(si[i]==ej[j] || ej[j]=='.') && dp[i+1][j+1];
                    }else{
                    int ss=i;
                    while(ss!=si.length && (si[ss]==ej[j] || ej[j]=='.')){
                        if(dp[ss][j+2]){
                            dp[i][j]=true;
                            break;
                        }
                        ss++;
                    }
                    if(dp[i][j]!=true){
                        dp[i][j]=dp[ss][j+2];
                    }
                }
            }
        }
        return dp[0][0];
    }

    private static boolean[][] initDP(char[] si, char[] ej) {
        int slength=si.length;
        int elength=ej.length;
        boolean[][] dp=new boolean[slength+1][elength+1];
        dp[slength][elength]=true;
        for(int j=elength-2;j>-1;j-=2){
            if(ej[j+1]=='*' && ej[j]!='*'){
                dp[slength][j]=true;
            }else{
                break;
            }
        }
        if(slength>0 && elength>0){
            if(ej[slength-1]=='.' || si[slength-1]==ej[elength-1]){
                dp[slength-1][elength-1]=true;
            }
        }
        return  dp;
    }
}
