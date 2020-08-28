package com.dongdong.spring.test.DesignMode.strategyPatternDemo;

/**
 * @Description:
 * @Date: 2020/8/28  9:24
 * @Author: dongdong
 */
public class StratePatternDemo {
    public static void main(String[] args) {
        Context context=new Context(new OperationAdd());
        System.out.println(context.executeStrategy(1,2));
    }
}
