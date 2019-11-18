package com.dongdong.spring.test.javaProxy1;

/**
 * @Description:
 * @Date: 2019/11/16  16:46
 * @Author: dongdong
 */
public class Proxy implements Rent {
    private Host host;

    public void setHost(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
    }
}
