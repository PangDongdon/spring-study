package com.dongdong.spring.test2.waitAndNotify;

/**
 * @Description:
 * @Date: 2021/2/5  16:08
 * @Author: dongdong
 */
public class Express {

    public final static  String CITY="hf";
    private int km;//快递里程数
    private String site; //快递地点

    public  Express(){

    }
    public Express(int km,String site){
        this.km=km;
        this.site=site;
    }
    public synchronized void changeKm(){
        this.km=1;
        notifyAll();
    }
    public synchronized void  changeSite(){
        this.site="Beijing";
         notifyAll();
    }

    public  synchronized  void waitKm(){

    }

}
