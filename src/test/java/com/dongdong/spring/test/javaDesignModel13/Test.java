package com.dongdong.spring.test.javaDesignModel13;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  14:55
 */

public class Test {

    public static void main(String[] args) {
        RequestHandle hr = new HRRequestHandle();
        RequestHandle pm = new PMRRequestHandle(hr);
        RequestHandle tl = new TLRRequestHandle(pm);


        //team leader 处理离职请求
        Request request = new DimissionRequest();
        tl.handleRequest(request);

        System.out.println("==============");


        //team leader 处理加薪请求
        request = new AddMoneyRequest();
        tl.handleRequest(request);

        System.out.println("==============");

        //项目经理上理辞职请求
        request = new DimissionRequest();
        pm.handleRequest(request);
    }


}
