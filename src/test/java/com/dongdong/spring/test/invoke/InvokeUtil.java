package com.dongdong.spring.test.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description: 反射工具类
 * @Date: 2020/6/15  9:58
 * @Author: dongdong
 */
public class InvokeUtil {

    public  static Object invoke(Object  object,String methodName,String paramName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
     Method method= object.getClass().getDeclaredMethod(methodName,String.class);
     Object result= method.invoke(object,paramName);
     return  result;
    }
}
