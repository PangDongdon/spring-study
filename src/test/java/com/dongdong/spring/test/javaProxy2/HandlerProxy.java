package com.dongdong.spring.test.javaProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Date: 2020/6/1  10:39
 * @Author: dongdong
 */
public class HandlerProxy implements InvocationHandler {
    private Object object;

    public HandlerProxy(Object object) {
        this.object = object;
    }
    public  Object getInstance(){
    return   Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
  }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        aa();
        Object object1= method.invoke(object,args);
        bb();
        return object1;
    }
    void aa(){
      System.out.println("1");
    }
    void bb(){
        System.out.println("2");
    }
}
