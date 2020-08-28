package com.dongdong.spring.test.DesignMode.FilterModel;

/**
 * @Description:
 * @Date: 2020/8/28  16:42
 * @Author: dongdong
 */
public class InterceptingFilterDemo {

    public static void main(String[] args) {
        FilterManager filterManager=new FilterManager(new Target());
        filterManager.setFilter(new AuthenticationFilter());
        filterManager.setFilter(new DebugFilter());
         Client client=new Client();
         client.setFilterManager(filterManager);
         client.sendRequest("HOME");
    }
}
