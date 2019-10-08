package com.dongdong.spring.test.javaDesignModel13;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  14:40
 */
public class PMRRequestHandle implements RequestHandle {

    RequestHandle  rh;
    public PMRRequestHandle(RequestHandle rh){
        this.rh=rh;
    }

    @Override
    public void handleRequest(Request request) {
        if(request instanceof AddMoneyRequest){
            System.out.println("需要加新，项目经理批准");
        }else{
          rh.handleRequest(request);
        }
    }
}
