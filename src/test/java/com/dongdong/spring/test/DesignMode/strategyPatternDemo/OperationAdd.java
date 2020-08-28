package com.dongdong.spring.test.DesignMode.strategyPatternDemo;

/**
 * @Description:
 * @Date: 2020/8/27  18:03
 * @Author: dongdong
 */
public class OperationAdd  implements  Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1+num2;
    }
}
