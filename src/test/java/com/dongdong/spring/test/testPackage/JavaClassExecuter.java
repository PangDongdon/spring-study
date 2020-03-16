package com.dongdong.spring.test.testPackage;

import java.lang.reflect.Method;

/**
 * @Description: JavaClassExecuter 执行工具
 * @Date: 2019/11/21  17:29
 * @Author: dongdong
 */
public class JavaClassExecuter {

    public  static String execute(byte[] classByte){
        HackSystem.clearBuffer();
        ClassModifier cm=new ClassModifier(classByte);
        byte[] modiBytes=cm.modifyUTF8Constant("java/lang/System","org/fenixsoft/classloading/execute/HackSystem");
        HotSwpclassLoader loader=new HotSwpclassLoader();
        Class clazz=loader.loadByte(modiBytes);
        try{
            Method method=clazz.getMethod("main",new Class[]{String[].class});
            method.invoke(null,new String[]{null});
        }catch(Exception e){
          e.printStackTrace(HackSystem.out);
        }
        return  HackSystem.getBufferString();
    }





}
