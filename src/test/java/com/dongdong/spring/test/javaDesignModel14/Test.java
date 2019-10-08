package com.dongdong.spring.test.javaDesignModel14;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  16:50
 */
public class Test {
    public  static void main(String[] args){
        Receiver receiver=new Receiver();
        Commmand commmand=new CommandIml(receiver);
        Invoker i=new Invoker();
        i.setCommmand(commmand);
        i.excute();
    }
}
