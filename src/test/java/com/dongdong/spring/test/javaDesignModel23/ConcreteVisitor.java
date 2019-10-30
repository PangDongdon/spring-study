package com.dongdong.spring.test.javaDesignModel23;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  15:08
 */
public class ConcreteVisitor implements Visitor {

    public void visitString(StringElement stringElement) {
         System.out.println(stringElement.getSe());
    }


    public void visitFsloat(FloatElement floatElement) {
        System.out.println(floatElement.getFe());
    }


    public void visitCollection(Collection collection) {
        Iterator iterator=collection.iterator();
        while(iterator.hasNext()){
            Object o=iterator.next();
            if(o instanceof  Visitable){
                ((Visitable)o).accept(this);
            }
        }
    }
}
