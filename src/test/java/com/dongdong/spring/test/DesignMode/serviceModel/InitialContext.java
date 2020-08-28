package com.dongdong.spring.test.DesignMode.serviceModel;

/**
 * @Description:
 * @Date: 2020/8/28  17:05
 * @Author: dongdong
 */
public class InitialContext {
    public Object  lookup(String jndiName){
        if(jndiName.equalsIgnoreCase("service1")){
            System.out.println("Looking up and creating a new Service1 object");
            return  new Service1();
        }else if(jndiName.equalsIgnoreCase("service2")){
            System.out.println("Looking up and creating a new Service2 object");
            return  new Service2();
        }
        return  null;
    }
}
