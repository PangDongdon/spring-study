package com.dongdong.spring.test.eventListenter;

/**
 * @Description:
 * @Date: 2019/12/20  18:20
 * @Author: dongdong
 */
public interface  EventSource {

    //增加监听器
    void addListener(EventListenter listenter);

    //通知监听器
    void  notifyListener();
}
