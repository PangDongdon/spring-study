package com.dongdong.spring.test.javaDesignModel14;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  15:40
 */
public class Invoker {

    private Commmand commmand;
    public void setCommmand(Commmand commmand){
        this.commmand=commmand;
    }

    public void excute(){
        commmand.excute();
    }
}
