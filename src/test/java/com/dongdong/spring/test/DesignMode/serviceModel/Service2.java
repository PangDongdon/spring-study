package com.dongdong.spring.test.DesignMode.serviceModel;

/**
 * @Description:
 * @Date: 2020/8/28  17:03
 * @Author: dongdong
 */
public class Service2 implements  Service {
    @Override
    public String getName() {
        return "service2";
    }

    @Override
    public void execute() {
     System.out.println("Executing Service2");
    }
}
