package com.dongdong.spring.test.javaDesignModel9;

/**
 * 装饰者模式
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  9:40
 */
public class Test {

    public static void main(String[] args){

       Man m=new Man();
       ManDecoratorA a=new ManDecoratorA();
       ManDecoratorB b=new ManDecoratorB();
       a.setPerson(m);
       b.setPerson(a);
       b.eat();
    }

}
