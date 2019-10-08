package com.dongdong.spring.test.javaDesignModel22;

/** 模板方法
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  14:05
 */
public class Test {

    public static  void main(String[] args){
        Template concrete=new TemplateConcrete();
        concrete.update();
    }
}
