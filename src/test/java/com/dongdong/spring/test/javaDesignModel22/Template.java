package com.dongdong.spring.test.javaDesignModel22;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  14:01
 */
public  abstract class Template {
    public  abstract  void print();
    public void update(){
        System.out.println("开始打印");
        for(int i=0;i<10;i++){
            print();
        }
    }
}
