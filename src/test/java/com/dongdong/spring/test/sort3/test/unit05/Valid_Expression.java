package com.dongdong.spring.test.sort3.test.unit05;

import org.apache.logging.log4j.util.Strings;

import java.util.Stack;

public class Valid_Expression {

    public static boolean isValidExpression(String str) {
        if (Strings.isBlank(str)) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '{' || chars[i] == '[' || chars[i] == '(') {
                stack.add(chars[i]);
            }
            if (chars[i] == '}' || chars[i] == ']' || chars[i] == ')') {
                Character match = chars[i] == '}' ? '{' : chars[i] == ']' ? '[' : '(';
                if (stack.isEmpty() || !match.equals(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "{1+(2+3)+[(1+3)+(4*5)]}";
        System.out.println(isValidExpression(test));
    }

}
