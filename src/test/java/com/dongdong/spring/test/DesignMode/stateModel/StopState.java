package com.dongdong.spring.test.DesignMode.stateModel;

/**
 * @Description:
 * @Date: 2020/8/27  17:10
 * @Author: dongdong
 */
public class StopState implements  State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }
    public String toString(){
        return  "Stop State";
    }
}
