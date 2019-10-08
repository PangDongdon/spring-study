package com.dongdong.spring.test.javaDesignModel6;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  14:47
 */
public class Client {

    public static void main(String[] args){
        Adapter adapter=new Adapter(new Adaptee());
        adapter.adapteeMethod();
        adapter.adapterMethod();
    }
}
