package com.dongdong.spring.test.jvm.jvmLoad;

/**
 * @Description:
 * @Date: 2020/11/5  18:32
 * @Author: dongdong
 */
public class SlotTest {

    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int t=0;
        System.gc();
    }
}
