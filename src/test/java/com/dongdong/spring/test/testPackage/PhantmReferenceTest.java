package com.dongdong.spring.test.testPackage;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Description:
 * @Date: 2020/5/7  13:56
 * @Author: dongdong
 */
public class PhantmReferenceTest {
    public static void main(String[] args) {
        String str=new String("java 学习");
        ReferenceQueue rq=new ReferenceQueue();
        PhantomReference pr =new PhantomReference<>(str,rq);
        str=null;
        System.out.println("未回收前"+pr.get());
        System.gc();
        System.runFinalization();
        System.out.println(rq.poll()==pr);

    }
}
