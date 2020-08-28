package com.dongdong.spring.test.DesignMode.FilterModel;

/**
 * @Description:
 * @Date: 2020/8/28  16:22
 * @Author: dongdong
 */
public class FilterManager {
    FilterChain filterChain;

    public FilterManager(Target target){
        filterChain=new FilterChain();
        filterChain.setTarget(target);
    }

    public void  setFilter(Filter filter){
        filterChain.addFilter(filter);
    }

    public  void  filterRequest(String request){
        filterChain.execute(request);
    }
}
