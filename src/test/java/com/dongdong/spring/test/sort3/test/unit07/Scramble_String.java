package com.dongdong.spring.test.sort3.test.unit07;

import com.graphbuilder.math.func.EFunction;
import org.apache.logging.log4j.util.Strings;

public class Scramble_String {

    //递归版本
    public static  boolean isScramble1(String s1,String s2){
        if(Strings.isBlank(s1) || Strings.isBlank(s2)){
            return false;
        }
        if(s1.length()!=s2.length()){
            return  false;
        }
        if(s1.equals(s2)){
            return true;
        }
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int N=s1.length();
        return func(c1,c2,0,0,N);
    }

    private static boolean func(char[] c1, char[] c2, int L1, int L2, int size) {
        if(size==1){
            return c1[L1]==c2[L2];
        }
        for(int part=1;part<size;part++){
            return (func(c1,c2,L1,L2,part) && func(c1,c2,L1+part,L2+part,size-part))
                    || (func(c1,c2,L1,L2+size-part,part) && func(c1,c2,L1+part,L2,size-part));
        }
        return false;
    }

    //动态规划
    public static  boolean isScramble2(String s1,String s2) {
        if (Strings.isBlank(s1) || Strings.isBlank(s2)) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int N = s1.length();
        boolean[][][] dp=new boolean[N][N][N+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dp[i][j][1]=c1[i]==c2[j];
            }
        }

        for(int size=2;size<=N;size++){
            for(int L1=0;L1<=N-size;L1++){
                for(int L2=0;L2<=N-size;L2++){
                    for(int p=1;p<size;p++){
                        if((func(c1,c2,L1,L2,p) && func(c1,c2,L1+p,L2+p,size-p))
                                || (func(c1,c2,L1,L2+size-p,p) && func(c1,c2,L1+p,L2,size-p))){
                         dp[L1][L2][size]=true;
                         break;
                        }
                    }
                }
            }
        }
        return dp[0][0][N];
    }

    public static void main(String[] args) {
        String test1 = "bcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcdebcde";
        String test2 = "cebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebdcebd";
        System.out.println(isScramble1(test1, test2));
        System.out.println(isScramble2(test1, test2));
    }

}
