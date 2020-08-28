package com.dongdong.spring.test.DesignMode.serviceModel;

/**
 * @Description:
 * @Date: 2020/8/28  17:02
 * @Author: dongdong
 */
public class Service1 implements  Service {
    @Override
    public String getName() {
        return "service1";
    }

    @Override
    public void execute() {
    System.out.println("Executing Service1");
    }
}
