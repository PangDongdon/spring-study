package com.dongdong.spring.test.javaDesignModel15;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  17:12
 */
public class Context {

    private String content;

    private List list=new ArrayList();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void add(Expression expression){
        list.add(expression);
    }
    public List<Expression> getList(){
        return  list;
    }
}
