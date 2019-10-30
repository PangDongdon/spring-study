package com.dongdong.spring.test.testPackage;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2019/10/17  17:17
 * @Author: dongdong
 */
public class ReferenceCountingGC {

    public Object instance=null;
    private  static  final int _1MB=1024*1024;
    private byte[] bigSize=new byte[2*_1MB];
    @Test
    public  void testGC(){
        ReferenceCountingGC objA=new ReferenceCountingGC();
        ReferenceCountingGC objB=new ReferenceCountingGC();
        objA.instance=objB;
        objB.instance=objA;

        objA=null;
        objB=null;
        //假设在这行发生GC,objA和objB 是否能被回收
        System.gc();
    }




}
