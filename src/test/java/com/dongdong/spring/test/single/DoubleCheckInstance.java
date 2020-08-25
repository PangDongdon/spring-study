package com.dongdong.spring.test.single;

/**
 * @Description:
 * @Date: 2020/8/24  14:22
 * @Author: dongdong
 */
public class DoubleCheckInstance {
    private volatile  DoubleCheckInstance doubleCheckInstance;
    private DoubleCheckInstance(){

    }
    public DoubleCheckInstance getInstance(){
        if(doubleCheckInstance==null){
            synchronized(DoubleCheckInstance.class){
                if(doubleCheckInstance==null){
                    return  new DoubleCheckInstance();
                }
            }
        }
        return  doubleCheckInstance;
    }

}
