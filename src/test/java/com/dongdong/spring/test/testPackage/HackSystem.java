package com.dongdong.spring.test.testPackage;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * @Description: java class 劫持 java.lang.string 提供支持
 * @Date: 2019/11/21  17:05
 * @Author: dongdong
 */
public class HackSystem {

    public final static InputStream in =System.in;

    private static ByteArrayOutputStream buffer=new ByteArrayOutputStream();
    public static PrintStream out=new PrintStream(buffer);
    public  final static  PrintStream err=out;

    public static  String getBufferString(){
       return buffer.toString();
    }
    public static void clearBuffer(){
        buffer.reset();
    }
    public static void setSecurityManager(final  SecurityManager s){
        System.setSecurityManager(s);
    }

    public static SecurityManager getSecurityManager(){
        return System.getSecurityManager();
    }
    public  static  long  currentTimeMillis(){
        return System.currentTimeMillis();
    }


    public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length){
        System.arraycopy(src,srcPos,dest,destPos,length);
    }
}
