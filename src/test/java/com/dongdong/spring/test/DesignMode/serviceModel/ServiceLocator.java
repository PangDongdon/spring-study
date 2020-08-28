package com.dongdong.spring.test.DesignMode.serviceModel;



/**
 * @Description:
 * @Date: 2020/8/28  17:19
 * @Author: dongdong
 */
public class ServiceLocator {

    private static Cache cache;

    static{
        cache=new Cache();
    }

    public static Service  getService(String  jndiName){
        Service service=cache.getService(jndiName);
        if(service!=null){
            return  service;
        }
        InitialContext initialContext=new InitialContext();
        Service service1=(Service)initialContext.lookup(jndiName);
        cache.addService(service1);
        return service1;
    }
}
