package com.dongdong.spring.test.javaDesignModel23;

import java.util.Collection;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  14:53
 */
public interface Visitor {

     void  visitString(StringElement stringElement);
     void  visitFsloat(FloatElement floatElement);
     void  visitCollection(Collection collection);
}
