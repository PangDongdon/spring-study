package com.dongdong.spring.test.DesignMode.strategyPatternDemo;

/**
 * @Description:
 * @Date: 2020/8/27  18:03
 * @Author: dongdong
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }

}
