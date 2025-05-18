package com.dongdong.spring.leetcodetop100_2;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 字符串解码
 */
public class Top71DecodeString {
    //2[a]
    int index = 0;

    public String decodeString(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        LinkedList<String> stack = new LinkedList<>();
        index = 0;
        int length = s.length();
        while (index < length) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                stack.addLast(getDigit(s));
            } else if (Character.isLetter(c) || '[' == c) {
                stack.addLast(String.valueOf(s.charAt(index++)));
            } else {
                ++index;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }
                Collections.reverse(sub);
                //左括号出栈
                stack.removeLast();
                int time = Integer.parseInt(stack.removeLast());
                String o = getString(sub);
                StringBuffer ss = new StringBuffer();
                while (time-- > 0) {
                    ss.append(o);
                }
                stack.addLast(ss.toString());
            }
        }
        return getString(stack);
    }

    private String getString(LinkedList<String> stack) {
        StringBuffer sd = new StringBuffer();
        for (String s : stack) {
            sd.append(s);
        }
        return sd.toString();
    }

    private String getDigit(String s) {
        StringBuffer sb = new StringBuffer();
        while (Character.isDigit(s.charAt(index))) {
            sb.append(s.charAt(index++));
        }
        return sb.toString();
    }
}
