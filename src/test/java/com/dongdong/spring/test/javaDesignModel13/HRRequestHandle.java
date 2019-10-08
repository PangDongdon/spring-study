package com.dongdong.spring.test.javaDesignModel13;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  14:38
 */
public class HRRequestHandle implements RequestHandle {
    @Override
    public void handleRequest(Request request) {
        if(request instanceof DimissionRequest){
            System.out.println("需要离职，人事批准");
        }
            System.out.println("请求完毕");
    }
}
