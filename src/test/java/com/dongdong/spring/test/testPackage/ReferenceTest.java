package com.dongdong.spring.test.testPackage;

import java.lang.ref.WeakReference;

/**
 * @Description:
 * @Date: 2020/5/7  13:29
 * @Author: dongdong
 */
public class ReferenceTest {
    public static void main(String[] args) {
        String str=new String("ddddd");
       // String str ="dd";
        WeakReference wr=new WeakReference(str);

        str=null;

        System.out.println("回收前"+wr.get());

        //强制回收
        System.gc();

        System.runFinalization();

        System.out.println("回收后"+wr.get());
    }
}
