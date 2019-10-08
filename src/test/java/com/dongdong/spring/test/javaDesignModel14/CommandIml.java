package com.dongdong.spring.test.javaDesignModel14;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  15:39
 */
public class CommandIml  extends  Commmand{
    public CommandIml(Receiver receiver){
        super(receiver);
    }
    @Override
    public void excute() {
        receiver.excute();
    }
}
