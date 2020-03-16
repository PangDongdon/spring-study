package com.dongdong.spring.test.Locktest;

/**
 * @Description:
 * @Date: 2019/11/27  15:16
 * @Author: dongdong
 */
public class threadLocal implements Runnable {

    public static void main(String[] args){
        for(int i=0;i<3;i++){
            Thread thread=new Thread(new threadLocal());
            thread.start();
        }
    }

    @Override
    public void run() {
        ThreadLocal s=new ThreadLocal();
        s.set("qqqq");
        System.out.println(Thread.currentThread().getName()+"："+s.get());
    }
}
