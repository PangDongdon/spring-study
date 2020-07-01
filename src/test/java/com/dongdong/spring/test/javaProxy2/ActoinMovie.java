package com.dongdong.spring.test.javaProxy2;


import org.junit.Test;

/**
 * @Description:
 * @Date: 2020/6/1  10:37
 * @Author: dongdong
 */
public class ActoinMovie implements Movie {
    @Override
    public void watchMovie() {
        System.out.println("看武打电影");
    }

    @Test
    public void test() throws ClassNotFoundException {
        ActoinMovie actoinMovie=new ActoinMovie();
        System.out.println(Class.forName("com.dongdong.spring.test.javaProxy2.ActoinMovie"));
        System.out.println(actoinMovie.getClass());
        System.out.println(ActoinMovie.class);
    }

}
