package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/12/18  19:31
 * @Author: dongdong
 */
public class VolitileTest {

    public  static  volatile   int race=0;

    public  static  void increase(){
        race++;
    }
    private static final int THREAD_COUNT=20;

    public static void  main(String[] args){
        Thread[] threads=new Thread[THREAD_COUNT];
        for(int i=0;i<THREAD_COUNT;i++){
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<1000;i++){
                        increase();
                    }
                }
            });
            threads[i].start();
        }
       while (Thread.activeCount()>2){
           Thread.yield();
           System.out.println("线程做出让步"+Thread.currentThread().getName());
       }
       System.out.println(race);
    }
}
