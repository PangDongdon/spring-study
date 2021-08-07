package com.dongdong.spring.test.leetCode.stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @Description: 有效的括号
 * @Date: 2020/12/16  13:26
 * @Author: dongdong
 */
public class Sort20 {

    public boolean checkValidBrackets(String s){
        //创建存储栈
        Stack<Character> stack=new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['|| s.charAt(i)=='(' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){
                    return  false;
                }else if(s.charAt(i)==']' && stack.peek()!='['){
                    return  false;
                }else if(s.charAt(i)==')' && stack.peek()!='('){
                    return  false;
                }else if(s.charAt(i)=='}' && stack.peek()!='{'){
                    return  false;
                }
                stack.pop();
            }
        }
        return  true;
    }


    @Test
    public void  test(){
        System.out.println(checkValidBrackets("{[)]}"));
    }
}
