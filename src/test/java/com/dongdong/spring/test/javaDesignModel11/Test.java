package com.dongdong.spring.test.javaDesignModel11;

/**享元模式
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/30  11:26
 */
public class Test {
  public static void main(String[] args){

     Flyweight f1=FlyweightFactory.getFlyweight("a");
     f1.action(1);

      Flyweight f2=FlyweightFactory.getFlyweight("a");
      System.out.println(FlyweightFactory.getFlyweight("a"));
      System.out.println(f1==f2);

      Flyweight f3=FlyweightFactory.getFlyweight("b");
      f3.action(2);


      Flyweight f34=FlyweightFactory.getFlyweight("c");
      f3.action(3);


      Flyweight f5=FlyweightFactory.getFlyweight("d");
      f3.action(4);

      System.out.println(FlyweightFactory.getSize());
  }



}
