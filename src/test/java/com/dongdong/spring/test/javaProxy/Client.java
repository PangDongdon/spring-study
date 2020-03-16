package com.dongdong.spring.test.javaProxy;

/**
 * @Description:
 * @Date: 2019/11/16  16:17
 * @Author: dongdong
 */
public class Client {
    public static void main(String[] args){
        Host host=new Host();
        ProxyInovationHandler pih=new ProxyInovationHandler();
        pih.setTarget(host);
        Rent proxy=(Rent)pih.getProxy();
        proxy.rent();
    }
}
