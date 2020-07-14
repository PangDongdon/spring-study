package com.dongdong.spring.test.observerOfDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/7/14  11:08
 * @Author: dongdong
 */
public class Subject {

    private List<Observer> observers=new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public  void notifyAllObservers(){
        for(Observer observer:observers){
            observer.update();
        }
    }

}
