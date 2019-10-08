package com.dongdong.spring.test.javaDesignModel14;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  15:38
 */
public abstract class Commmand {
    protected  Receiver receiver;
    public Commmand(Receiver receiver){
        this.receiver=receiver;
    }
    public abstract  void excute();

}
