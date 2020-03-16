package com.dongdong.spring.test.WriteProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Date: 2019/12/9  16:13
 * @Author: dongdong
 */
public class RentNoHandler implements InvocationHandler {
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object  getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
     @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         lookHouse();
         Object object= method.invoke(target,args);
         giveMoney();
         return object;
    }


    public void lookHouse(){
        System.out.println("看房");
    }

    public void giveMoney(){
        System.out.println("付钱");
    }
}
