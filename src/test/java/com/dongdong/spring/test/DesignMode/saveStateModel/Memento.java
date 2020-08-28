package com.dongdong.spring.test.DesignMode.saveStateModel;

/**
 * @Description:
 * @Date: 2020/8/27  11:23
 * @Author: dongdong
 */
public class  Memento {

    private String state;

    public Memento(String state){
        this.state=state;
    }

    public String getState(){
        return  state;
    }
}
