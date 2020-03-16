package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/12/19  10:27
 * @Author: dongdong
 */
public class Singleton {

    private volatile static Singleton  instance;

    public Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
       return instance;
    }

}
