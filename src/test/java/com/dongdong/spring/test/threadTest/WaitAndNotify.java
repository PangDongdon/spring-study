package com.dongdong.spring.test.threadTest;

import io.netty.util.concurrent.RejectedExecutionHandlers;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Date: 2020/7/31  11:51
 * @Author: dongdong
 */
public class WaitAndNotify {
    private  static final    String  SITE="AnHui";
    private  String site;

    public WaitAndNotify(String site){
        this.site=site;
    }

    public  synchronized  void   changeSite(){
        this.site="ss";
        this.notifyAll();
    }

    public synchronized  void site(){

        while(this.site.equals(SITE)){
            try {
               this.wait();
                System.out.println("wait 被执行");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("执行业务method");
    }


    private  static class  SS extends  Thread{
      private   WaitAndNotify waitAndNotify;
       public  SS( WaitAndNotify waitAndNotify){
           this.waitAndNotify=waitAndNotify;
       }
        @Override
        public void run(){
            waitAndNotify.site();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify waitAndNotify = new WaitAndNotify(SITE);
        SS ss = new SS(waitAndNotify);
        ss.start();
        Thread.sleep(1000);
        waitAndNotify.changeSite();
    }
}
