package com.dongdong.spring.test.javaReflect;


import java.lang.reflect.InvocationTargetException;

/**
 * @Description:
 * @Date: 2019/11/21  18:45
 * @Author: dongdong
 */
public class Factory {

   public   static  <T> T getInstance(String classNmae,Class<T> T)
   {
       T instance=null;
       try {
           instance= (T) Class.forName(classNmae).getDeclaredConstructor().newInstance();
       }catch(Exception e){
           e.printStackTrace();
       }
       return  instance;
    }
    public static void main(String[] args) throws  Exception{
      /*  Factory.getInstance("com.dongdong.spring.test.javaReflect.userServiceImpl",userService.class).getProvide();*/
        for(int x=0;x<3;x++){
            new Thread(()->{Singlton.getInStance().say();},"创建单例实体"+x).start();
        /* new Thread(new Runnable() {
             @Override
             public void run() {
                 Singlton.getInStance().say();
             }
         },"单利"+x).start();*/
        }
    }
}

class userServiceImpl implements  userService{
    @Override
    public void getProvide() {
        System.out.println("提供租房");
    }
}

class Singlton {
    private   static Singlton singlton=null;
    public  Singlton(){
        System.out.println(Thread.currentThread().getName()+"创建一个实例");
    }
    public  static  Singlton getInStance(){
            if (singlton == null) {
                synchronized (Singlton.class) {
                    if(singlton==null) {
                        singlton = new Singlton();
                    }
            }
        }
        return  singlton;
    }
  public void  say(){
        System.out.println("这是单例模式");
  }

}






