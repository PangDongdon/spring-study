package com.dongdong.spring.test.DesignMode.saveStateModel;

/**
 * @Description:
 * @Date: 2020/8/27  11:35
 * @Author: dongdong
 */
public class MementoPatternDemo {

    public static void main(String[] args) {
        Originator originator=new Originator();
        originator.setState("1");
        originator.setState("2");
        CareTaker careTaker=new CareTaker();
        careTaker.add(originator.saveToMemento());
        originator.setState("3");
        careTaker.add(originator.saveToMemento());
        originator.setState("4");
        careTaker.add(originator.saveToMemento());
        //当前状态
        System.out.println(originator.getState());
        //获取以前存储状态
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println(originator.getState());

    }

}
