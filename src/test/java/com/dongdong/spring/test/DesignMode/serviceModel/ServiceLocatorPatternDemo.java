package com.dongdong.spring.test.DesignMode.serviceModel;

/**
 * @Description:
 * @Date: 2020/8/28  17:26
 * @Author: dongdong
 */
public class ServiceLocatorPatternDemo {

    public static void main(String[] args) {
        Service service = ServiceLocator.getService("service1");
        service.execute();
        service = ServiceLocator.getService("service2");
        service.execute();
        service = ServiceLocator.getService("service1");
        service.execute();
        service = ServiceLocator.getService("service2");
        service.execute();
    }
}
