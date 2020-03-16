package com.dongdong.spring.test.eventListenter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/12/20  18:33
 * @Author: dongdong
 */
public class MySource implements  EventSource {

    private List<EventListenter> listenters=new ArrayList<EventListenter>();

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyListener();
    }

    @Override
    public void addListener(EventListenter listenter) {
        listenters.add(listenter);
    }

    @Override
    public void notifyListener() {
     for(EventListenter eventListenter:listenters){
         MyEvent event=new MyEvent();
         event.setSource(this);
         event.setWhen(new Date());
         event.setMessage("setValue:"+value);
         eventListenter.handleEvent(event);
     }
    }


    @Test
    public void testEventListener(){
        MySource mySource=new MySource();
        mySource.addListener(new MyListener());
        mySource.setValue(100);
    }
}
