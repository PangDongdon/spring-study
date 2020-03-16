package com.dongdong.spring.test.testPackage;

import java.util.Collections;
import java.util.Vector;

/** 线程绝对安全测试
 * @Description:
 * @Date: 2019/12/24  11:27
 * @Author: dongdong
 */
public class VectorTest {
    private static Vector<Integer> vector=new Vector<>();
    public static  void main(String[] args){

        while(true){
            for(int i=0;i<10;i++){
                vector.add(i);
            }

            Thread removeThread=new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector){
                        for(int i=0;i<vector.size();i++){
                          System.out.println(Thread.currentThread().getName()+"移除的数为"+vector.remove(i));
                        }
                    }
                }
            });

            Thread printThread=new Thread(new Runnable() {
                @Override
                public void run() {
                   synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                         System.out.println( vector.get(i));
                        }
                   }
                }
            });
            removeThread.start();printThread.start();
            while(Thread.activeCount()>20);
        }

    }



}
