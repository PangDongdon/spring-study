package com.dongdong.spring.test.swordFingerOffer;

/**
 * @Description: lazy mode   check again  + validate
 * @Date: 2020/7/27  16:33
 * @Author: dongdong
 */
public class SingleObject2 {

    private  volatile  static   SingleObject2 singleObject2=null;

    private SingleObject2(){

    }

    //双重检测
    public SingleObject2 getInstance(){
        if(singleObject2==null){
            synchronized (SingleObject2.class){
                if(singleObject2==null){
                    singleObject2=new SingleObject2();
                }
            }
        }
        return  singleObject2;
    }

    /**
     * 创建对象分三步：
     * 1）申请内存空间： address = allocate
     * 2）实例化对象：instance(object)
     * 3）myinstance = address
     * 创建对象是非原子性操作，第二步跟第三步在超高并发下可能会发生指令重排，其它线程可能会拿到属性为空的对象
     * 通过关键字：volatile，防止对象创建过程中发生指令重排
     * */

}
