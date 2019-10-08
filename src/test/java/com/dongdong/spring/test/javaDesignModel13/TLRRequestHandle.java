package com.dongdong.spring.test.javaDesignModel13;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  14:42
 */
public class TLRRequestHandle implements  RequestHandle {
    RequestHandle rh;
    public TLRRequestHandle( RequestHandle rh){
        this.rh=rh;
    }

    @Override
    public void handleRequest(Request request) {
        if(rh instanceof TLRRequestHandle){
            System.out.println("需要请假项目组长批准");
        }else{
            rh.handleRequest(request);
        }
    }
}
