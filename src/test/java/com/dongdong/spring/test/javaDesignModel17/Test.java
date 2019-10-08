package com.dongdong.spring.test.javaDesignModel17;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  10:36
 */
public class Test {
    public static void main(String[] args){
        Mediator m=new ConcreteMediator();
        m.notice("boss");
        m.notice("client");
    }
}
