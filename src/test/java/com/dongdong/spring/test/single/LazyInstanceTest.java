package com.dongdong.spring.test.single;

/**
 * @Description: 懒加载
 * @Date: 2020/8/24  14:20
 * @Author: dongdong
 */
public class LazyInstanceTest {
    private LazyInstanceTest lazyInstanceTest=new LazyInstanceTest();
    private LazyInstanceTest(){

    }

    public LazyInstanceTest getInstance(){
        return  lazyInstanceTest;
    }

}
