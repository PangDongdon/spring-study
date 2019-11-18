package com.dongdong.spring.test.javaProxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Date: 2019/11/16  16:11
 * @Author: dongdong
 */
public class ProxyInovationHandler implements InvocationHandler {
    private Object  target;

    public void setTarget(Object target) {
        this.target = target;
    }


    public Object getProxy(){
       return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
     seeHouse();
     Object object=method.invoke(target,args);
     getMoney();
     return object;
    }

    private void seeHouse(){
        System.out.println("看房");
    }
    public void getMoney(){
        System.out.println("收取中介费");
    }
}
