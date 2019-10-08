package com.dongdong.spring.test.javaDesignModel16;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  9:31
 */
public interface List {
    Iterator iterator();
    Object get(int index);
    int getSize();
    void  add(Object obj);
}
