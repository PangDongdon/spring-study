package com.dongdong.spring.test.javaDesignModel9;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  9:39
 */
public class ManDecoratorA  extends  Decorator {
    public void eat(){
        super.eat();
        Eat();
        System.out.println("A正在吃");
    }

    private void  Eat(){
        System.out.println("吃饱了");
    }
}
