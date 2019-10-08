package com.dongdong.spring.test.javaDesignModel9;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  9:39
 */
public class ManDecoratorB  extends  Decorator{
    public void eat(){
        super.eat();
        System.out.println("==================");
        System.out.println("B正在吃");
    }
}
