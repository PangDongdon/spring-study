package com.dongdong.spring.test.jvm;

/**
 * @Description:
 * @Date: 2020/10/27  16:26
 * @Author: dongdong
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while(true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
         thread.start();
        }
    }
    public static  void main(String[] args) throws  Throwable {
        JavaVMStackOOM omm = new JavaVMStackOOM();
        omm.dontStop();
        System.gc();
    }

}
