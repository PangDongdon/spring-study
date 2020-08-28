package com.dongdong.spring.test.DesignMode.FilterModel;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2020/8/28  16:19
 * @Author: dongdong
 */
public class FilterChain  {
    private List<Filter> filters=new ArrayList<>();
    private Target target;

    public void  addFilter(Filter filter){
        filters.add(filter);
    }

    public void  execute(String request){
        for (Filter filter:filters){
            filter.execute(request);
        }
        target.execute(request);
    }

    public void  setTarget(Target target){
        this.target=target;
    }
}
