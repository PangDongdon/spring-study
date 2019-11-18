package com.dongdong.spring.test.testPackage;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Date: 2019/11/15  14:47
 * @Author: dongdong
 */
public class ClassLoderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoder=new ClassLoader(){

            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try{

                    String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream  is=getClass().getResourceAsStream(fileName);
                    if(is==null){
                        return super.loadClass(name);
                    }
                    byte[] b=new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                }catch(IOException e){
                    throw new ClassNotFoundException();
                }
            }
        };
        Object obj=myLoder.loadClass("com.dongdong.spring.test.testPackage.ClassLoderTest").newInstance();
        System.out.println(obj.getClass());
        ClassLoader.getSystemClassLoader();
        System.out.println(obj instanceof com.dongdong.spring.test.testPackage.ClassLoderTest );
    }

}
