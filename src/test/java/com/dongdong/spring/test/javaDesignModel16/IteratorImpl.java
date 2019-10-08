package com.dongdong.spring.test.javaDesignModel16;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  9:24
 */
public class IteratorImpl implements  Iterator {
    private com.dongdong.spring.test.javaDesignModel16.List list;
    private int index;
    public  IteratorImpl(List list){
        index=0;
        this.list=list;
    }

    @Override
    public Object next() {
        Object obj=list.get(index);
        index++;
        return obj;
    }

    @Override
    public void first() {
     index=0;
    }

    @Override
    public void last() {
      index=list.getSize();
    }

    @Override
    public boolean hasNext() {
       return  index<list.getSize();
    }
}
