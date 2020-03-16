package com.dongdong.spring.test.eventListenter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 事件描述
 * @Date: 2019/12/20  18:05
 * @Author: dongdong
 */
public interface Event extends Serializable {
    Object getSource();

    Date getWhen();

    String getMessage();

    /**
     * 事件回调方法
     * */
    void callback();
}
