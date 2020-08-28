package com.dongdong.spring.test.DesignMode.strategyPatternDemo;

/**
 * @Description:
 * @Date: 2020/8/28  9:14
 * @Author: dongdong
 */
public class OperationSubtract implements  Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1-num2;
    }
}
