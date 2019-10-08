package com.dongdong.spring.test.javaDesignModel20;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  13:03
 */
public class Test {
    public  static void main(String[] args){
        Context  cx=new Context();
        cx.setWeather(new Sunshine());
        System.out.println(cx.weatherMessage());
    }
}
