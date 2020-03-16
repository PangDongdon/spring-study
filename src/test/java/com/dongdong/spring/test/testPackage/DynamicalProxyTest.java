package com.dongdong.spring.test.testPackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Date: 2019/11/20  17:23
 * @Author: dongdong
 */
public class DynamicalProxyTest {

    interface  IHello{
        void sayHello();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
      /*  IHello hello=(IHello)new DynamiclProxy().proxy(new Hello());*/
        UserService userService=new UserService();
        userService.send("hello world");

    }

  @Usemessage(clazz=Hello.class)
    static class UserService{
        private IHello hello;
        public UserService(){
            Usemessage usemessage= UserService.class.getAnnotation(Usemessage.class);
            Class<?> clazz=usemessage.clazz();
            this.hello=(IHello)Factory.getInstance(clazz);
        }
        public void send(String message){
            this.hello.sayHello();
        }
    }


    @Retention(RetentionPolicy.RUNTIME)
    @interface   Usemessage{
        Class<?> clazz();
    }

}

class Hello implements DynamicalProxyTest.IHello{
    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }
}
  class DynamiclProxy  implements InvocationHandler{
     Object target;
     Object proxy(Object target){
         this.target=target;
         return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
     }
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         System.out.println("welcme!come");
         return method.invoke(target,args) ;
      }

  }

  class Factory {
      private Factory() {}

      public static <T> T getInstance(Class<T> clazz) {
          try {
              return (T) new DynamiclProxy().proxy(clazz.getDeclaredConstructor().newInstance());
          } catch (Exception e) {
              e.getStackTrace();
              return  null;
          }
      }
  }




