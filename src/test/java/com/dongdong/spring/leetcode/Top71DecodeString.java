package com.dongdong.spring.leetcode;

import java.util.Collections;
import java.util.LinkedList;

/**
 *字符串解码
 */
public class Top71DecodeString {
    int index;
    public String decodeString(String s) {
      if(s=="" || s.length()<1){
          return null;
      }
        LinkedList<String> stack= new LinkedList<>();
        index=0;
        while (index<s.length()){
            Character c = s.charAt(index);
            if(Character.isDigit(c)){
                stack.addLast(getDigit(s));
            }else if(Character.isLetter(c) || '['==c){
                stack.addLast(String.valueOf(s.charAt(index++)));
            }else {
                ++index;
                LinkedList<String> sub=new LinkedList<>();
                while (!"[".equals(stack.peekLast())){
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);
                //左括号出栈
                stack.removeLast();
                int time=Integer.parseInt(stack.removeLast());
                String o=getString(sub);
                StringBuffer str=new StringBuffer();
                while (time-->0){
                   str.append(o);
                }
                stack.addLast(str.toString());
            }
        }
        return getString(stack);
    }

    private String getDigit(String s) {
        StringBuffer ret=new StringBuffer();
        while (Character.isDigit(s.charAt(index))){
           ret.append(s.charAt(index++));
        }
        return ret.toString();
    }

    private String getString(LinkedList<String> s){
        StringBuffer ret=new StringBuffer();
        for (String s1:s){
          ret.append(s1);
        }
        return ret.toString();
    }
}
