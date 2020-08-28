package com.dongdong.spring.test.DesignMode.stateModel;

/**
 * @Description:
 * @Date: 2020/8/27  17:09
 * @Author: dongdong
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public  String  toString(){
        return  "Start State";
    }
}
