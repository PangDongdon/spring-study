package com.dongdong.spring.test.DesignMode.iteratorModel;

/**
 * @Description:
 * @Date: 2020/8/27  10:26
 * @Author: dongdong
 */
public class IteratorPatternDemo {

    public static void main(String[] args) {
        NameRepositor nameRepositor=new NameRepositor();
        for(Iterator iterator=nameRepositor.getIterator();iterator.hasNext();){
            String name=(String)iterator.next();
            System.out.println("Name:"+name);
        }
    }

    /**
     * for(a；b；c){
     *     d;
     * }
     * a;初始条件 b:循环判断条件 c:  循环过程表达式(i++ i-- 等)   d： 方法体
     *  执行顺序为:a->b->d->c
     *
     * */
}
