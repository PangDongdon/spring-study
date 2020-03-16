package com.dongdong.spring.test.eventListenter;



/**
 * @Description:
 * @Date: 2019/12/20  18:17
 * @Author: dongdong
 */
public class MyListener implements EventListenter {


    @Override
    public void handleEvent(Event event) {
        event.callback();
    }
}
