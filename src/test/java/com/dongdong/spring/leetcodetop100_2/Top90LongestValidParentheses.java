package com.dongdong.spring.leetcodetop100_2;
/**
 *最初
 */
public class Top90LongestValidParentheses {
    public static int longestValidParentheses(String s) {
       int left=0,right=0,max=0;
       for(int i=0;i<s.length();i++){
           if('('==s.charAt(i)){
               left++;
           }else {
               right++;
           }
           if(left==right){
               max=Math.max(max,left*2);
           }
           if(right>left){
               left=right=0;
           }
       }
       left=right=0;
        for(int i=s.length()-1;i>=0;i--){
            if('('==s.charAt(i)){
                left++;
            }else {
                right++;
            }
            if(left==right){
                max=Math.max(max,left*2);
            }
            if(left>right){
                left=right=0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s="(()";
        int l=longestValidParentheses(s);
    }
}
