package com.dongdong.spring.test.WriteProxy;

/**
 * @Description:
 * @Date: 2019/12/9  16:12
 * @Author: dongdong
 */

public class Client {
    public static void main(String[] args){
         Host host=new Host();
         RentNoHandler fg=new RentNoHandler();
         fg.setTarget(host);
         Rent proxy=(Rent)fg.getProxy();
         proxy.rent();
    }
}
