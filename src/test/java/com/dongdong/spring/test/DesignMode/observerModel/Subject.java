package com.dongdong.spring.test.DesignMode.observerModel;



import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/8/27  13:36
 * @Author: dongdong
 */
public class Subject {
    private List<Observer> observers=new  ArrayList<>();
    private int state;

    public int getState(){
        return state;
    }
    public void  setState(int state){
        this.state=state;
        notifyAllObserver();
    }
    public void  notifyAllObserver(){
        for(Observer observer:observers){
            observer.update();
        }
    }

    public void attach(Observer observer){
        observers.add(observer);
    }
}
