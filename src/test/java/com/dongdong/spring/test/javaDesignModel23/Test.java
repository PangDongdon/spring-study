package com.dongdong.spring.test.javaDesignModel23;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  15:14
 */
public class Test {
    public  static void main(String[] args){
        Visitor visitor=new ConcreteVisitor();
        StringElement se=new StringElement("abc");
        se.accept(visitor);

        FloatElement fe=new FloatElement(new Float(1.5));
        fe.accept(visitor);
        System.out.println("================");


        List result=new ArrayList();
        result.add(new StringElement("addd"));
        result.add(new FloatElement(new Float(1.5)));
         visitor.visitCollection(result);
    }
}
