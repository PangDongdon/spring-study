package com.dongdong.spring.test.javaDesignModel12;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  13:47
 */
public class ObjectProxy implements Object {
    private ObjectImpl objectimpl;
    public ObjectProxy(){
        System.out.println("这是代理类");
        objectimpl=new ObjectImpl();
    }

    @Override
    public void action() {
      System.out.println("代理活动开始");
      objectimpl.action();
      System.out.println("代理活动结束");
    }
}
