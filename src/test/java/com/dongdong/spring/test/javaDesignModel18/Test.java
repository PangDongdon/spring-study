package com.dongdong.spring.test.javaDesignModel18;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  10:54
 */
public class Test{
    public static void main(String[] args){
       Originator originator=new Originator();
       originator.setState("开会中");

        Caretaker  caretaker=new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setState("睡觉中");
        originator.showState();
        originator.setSetMemento(caretaker.getMemento());
        originator.showState();
    }
}
