package com.dongdong.spring.leetcodetop100_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 */
public class Top71IsValid {
    public boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        Stack<Character> stack = new Stack<>();
        final char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c == '}' || c == ']' || c == ')') {
                if (stack.isEmpty() || map.get(c) != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
