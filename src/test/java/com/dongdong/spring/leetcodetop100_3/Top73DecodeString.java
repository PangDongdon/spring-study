package com.dongdong.spring.leetcodetop100_3;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 字符串解码
 */
public class Top73DecodeString {
    int index;

    public String decodeString(String s) {
        int length = s.length();
        if (length < 1) {
            return null;
        }
        LinkedList<String> stack = new LinkedList<>();
        while (index < length) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                stack.addLast(getDigit(s));
            } else if (Character.isLetter(c) || '[' == c) {
                stack.addLast(String.valueOf(s.charAt(index++)));
            } else {
                index++;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    sub.addLast(stack.removeLast());
                }

                Collections.reverse(sub);
                //移除[
                stack.removeLast();
                String subStr = getString(sub);
                int time = Integer.parseInt(stack.removeLast());
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < time; i++) {
                    sb.append(subStr);
                }
                stack.addLast(sb.toString());
            }
        }
        return getString(stack);
    }

    private String getDigit(String s) {
        StringBuffer sb = new StringBuffer();
        while (Character.isDigit(s.charAt(index))) {
            sb.append(s.charAt(index++));
        }
        return sb.toString();
    }

    private String getString(LinkedList<String> stack) {
        StringBuffer sb = new StringBuffer();
        for (String s : stack) {
            sb.append(s);
        }
        return sb.toString();
    }
}
