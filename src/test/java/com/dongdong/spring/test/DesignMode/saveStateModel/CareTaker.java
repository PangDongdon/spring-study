package com.dongdong.spring.test.DesignMode.saveStateModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/8/27  11:25
 * @Author: dongdong
 */
public class CareTaker {
    private List<Memento> mementoList=new ArrayList<>();

    public void  add(Memento memento){
        mementoList.add(memento);
    }

    public  Memento get(int index){
        return  mementoList.get(index);
    }
}
