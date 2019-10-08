package com.dongdong.spring.test.javaDesignModel21;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  13:52
 */
public class Context {
    private  Strategy strategy;
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    public void doMethod(){
        strategy.method();
    }
}
