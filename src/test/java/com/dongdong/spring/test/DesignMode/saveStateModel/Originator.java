package com.dongdong.spring.test.DesignMode.saveStateModel;

/**
 * @Description:
 * @Date: 2020/8/27  11:24
 * @Author: dongdong
 */
public class Originator {

    private String state;

    public void setState(String state){
        this.state=state;
    }

    public String getState(){
        return state;
    }

    public Memento saveToMemento(){
        return  new Memento(state);
    }

    public  void getStateFromMemento(Memento memento){
        state=memento.getState();
    }
}
