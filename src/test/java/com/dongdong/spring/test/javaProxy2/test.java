package com.dongdong.spring.test.javaProxy2;

/**
 * @Description:
 * @Date: 2020/6/1  10:52
 * @Author: dongdong
 */
public class test {

        public static void main(String[] args) {
                ActoinMovie actoinMovie = new ActoinMovie();
                HandlerProxy proxy = new HandlerProxy(actoinMovie);
                Movie actoinMovi1e = (Movie) proxy.getInstance();
                actoinMovi1e.watchMovie();
        }
}
