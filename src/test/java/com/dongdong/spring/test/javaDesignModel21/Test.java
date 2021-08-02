package com.dongdong.spring.test.javaDesignModel21;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  13:54
 */
public class Test {
    public static void main(String[] args){
        Context cx=new Context(new StrategyImplA());
        cx.doMethod();
        Context cxq=new Context(new StrategyImplB());
        cxq.doMethod();
    }
}
