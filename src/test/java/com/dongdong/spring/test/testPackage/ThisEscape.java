package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/12/20  16:30
 * @Author: dongdong
 */
public class ThisEscape {
     final int i;
     int j=0;
     static ThisEscape obj;
     public ThisEscape(){
         i=1;
         j=1;
         obj=new ThisEscape();
     }

     public static  void main(String[] args){
         Thread ThreadB=new Thread(new Runnable() {
             @Override
             public void run() {
                ThisEscape objB=obj;
                try{
                  System.out.println(objB.j);
                }catch(NullPointerException e){
                    System.out.println("空指针异常");
                }

                 try{
                     System.out.println(objB.i);
                 }catch(NullPointerException e){
                     System.out.println("空指针异常");
                 }
             }
         });
         ThreadB.start();
     }
}
