package com.dongdong.spring.test.single;

/**
 * @Description: 延迟占位模式
 * @Date: 2020/8/24  14:27
 * @Author: dongdong
 */
public class DelayInstance {
    private DelayInstance(){

    }

    private static class  HoldInstance{
      static   DelayInstance   delayInstance=new DelayInstance();
    }

    public DelayInstance getInstance(){
        return  HoldInstance.delayInstance;
    }
}
