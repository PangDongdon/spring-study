package com.dongdong.spring.leetcode;

import lombok.val;
import org.assertj.core.util.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 **/
public class Top69IsValid {
    Map<Character,Character> map= new HashMap<>();
    public boolean isValid(String s) {
       if(s==null){
           return false;
       }
       if(s.length()%2==1){
           return false;
       }
        map.put(']','[');
        map.put(')','(');
        map.put('}','{');
        Stack<Character> stack=new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char c:chars){
           if('}'==c || ']'==c || ')'==c){
               if(stack.isEmpty() || map.get(c)!=stack.peek()){
                   return false;
               }else {
                  stack.pop();
               }
           }else {
               stack.push(c);
           }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s="()";
        String s1="()[]{}";
        String s2="(]";
        String s3="([])";
    }
}
