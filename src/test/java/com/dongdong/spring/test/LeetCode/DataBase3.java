package com.dongdong.spring.test.LeetCode;

public class DataBase3 {
     private  static String s="bbbbb";
     public static void main(String[] args) {
        char[] c=s.toCharArray();
        for(int i=0;i<c.length;i++){
            for(int j=c.length;j<i;j--){
                if(c[i]==c[j]){
                    continue;
                }

            }
        }
    }
}
