package com.dongdong.spring.test.threadTest;

import java.util.stream.IntStream;

public enum Test {
    INSTANCE;
    private int i = 1;

    public void getInstance() {
        System.out.println(i++);
    }

    public static void main(String[] args) {
        IntStream.range(0, 100000).parallel().forEach(x ->
            INSTANCE.getInstance()
        );
    }
}
