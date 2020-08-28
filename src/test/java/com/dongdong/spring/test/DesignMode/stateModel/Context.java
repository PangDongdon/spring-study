package com.dongdong.spring.test.DesignMode.stateModel;

/**
 * @Description:
 * @Date: 2020/8/27  17:08
 * @Author: dongdong
 */
public class Context {
    private State state;

    public Context(){
        state=null;
    }

    public void setState(State state){
     //this.state=state;
    }

    public State getState(){
        return  state;
    }
}
