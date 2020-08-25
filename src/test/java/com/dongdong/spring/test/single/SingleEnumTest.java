package com.dongdong.spring.test.single;

/**
 * @Description: 枚举单例
 * @Date: 2020/8/24  13:57
 * @Author: dongdong
 */
public class SingleEnumTest {

    private  SingleEnumTest(){

    }

    public SingleEnumTest getInstance(){
       return  SingleEnum.ENUMTEST.getInstance();
    }


    private  static  enum  SingleEnum{
        ENUMTEST;
        private SingleEnumTest singleEnumTest;
        private   SingleEnum(){
            singleEnumTest=new SingleEnumTest();
        }
        public SingleEnumTest getInstance(){
             return  singleEnumTest;
        }

    }

}
