package com.dongdong.spring.test.javaProxy1;

import org.springframework.security.core.parameters.P;

/**
 * @Description:
 * @Date: 2019/11/16  16:47
 * @Author: dongdong
 */
public class Client {
    public static  void main(String[] args){
        Host host= new Host();
        Proxy proxy=new Proxy();
        proxy.setHost(host);
        one();
        proxy.rent();
        two();
    }

    private static  void  one(){
        System.out.println("去看房");
    }

    private  static void two(){
        System.out.println("收取中介");
    }
}
