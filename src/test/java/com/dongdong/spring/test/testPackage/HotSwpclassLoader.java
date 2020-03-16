package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/11/21  15:43
 * @Author: dongdong
 */
public class HotSwpclassLoader extends ClassLoader {

    public HotSwpclassLoader(){
        super(HotSwpclassLoader.class.getClassLoader());
    }
    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
