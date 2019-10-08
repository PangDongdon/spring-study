package com.dongdong.spring.test.javaDesignModel5;

import org.junit.Test;

/** 原型模式
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/26  19:55
 */
public class ConcretePrototype extends  Prototype {

    public  ConcretePrototype(String name){
        setName(name);
    }
    public ConcretePrototype(){

    }



    public static void main(String[] agr){
        Prototype pro=new ConcretePrototype("dongdong");
        Prototype   pro1=(Prototype)pro.clone();
        System.out.println(new ConcretePrototype("pang").getName()+":"+pro1.getName());
    }

}
