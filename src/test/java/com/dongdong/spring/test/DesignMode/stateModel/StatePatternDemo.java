package com.dongdong.spring.test.DesignMode.stateModel;

/**
 * @Description:
 * @Date: 2020/8/27  17:21
 * @Author: dongdong
 */
public class StatePatternDemo  {

    public static void main(String[] args) {

        Context context=new Context();

        StartState startState=new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());


        StartState stopState=new StartState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());

    }
}
