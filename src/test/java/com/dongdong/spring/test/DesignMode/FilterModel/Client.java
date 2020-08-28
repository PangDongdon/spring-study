package com.dongdong.spring.test.DesignMode.FilterModel;

/**
 * @Description:
 * @Date: 2020/8/28  16:38
 * @Author: dongdong
 */
public class Client {
    FilterManager filterManager;

    public  void   setFilterManager(FilterManager filterManager){
        this.filterManager=filterManager;
    }
    public void sendRequest(String request){
        filterManager.filterRequest(request);
    }
}
