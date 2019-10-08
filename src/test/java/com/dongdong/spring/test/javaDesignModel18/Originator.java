package com.dongdong.spring.test.javaDesignModel18;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  10:47
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public  Memento createMemento(){
        return new Memento(state);
    }

    public void setSetMemento(Memento memento) {
       state=memento.getState();
    }

    public void showState(){
        System.out.println(state);
    }
}
