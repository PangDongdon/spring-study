package com.dongdong.spring.test.DesignMode.iteratorModel;

/**
 * @Description:
 * @Date: 2020/8/27  10:21
 * @Author: dongdong
 */
public class NameRepositor implements Container {
    public String[] names={"dd","zp","hxl"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements  Iterator{
        int index;
        @Override
        public boolean hasNext() {
            if(index<names.length){
                return  true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return  names[index++];
            }
            return null;
        }
    }
}
