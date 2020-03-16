package com.dongdong.spring.test.testPackage;

/**
 * @Description: 组合测试
 * @Date: 2020/1/15  17:13
 * @Author: dongdong
 */
public class CompositeTest {
  public static  void main(String[] args){
      Animal a1=new Animal();
      Bird b=new Bird(a1);
      b.breath();
      b.fly();

      Animal a2=new Animal();
      Wolf w=new Wolf(a2);
      w.breath();
      w.run();
  }


}
    //定义动物类
    class Animal{
        private void beat(){
            System.out.println("心脏在跳动");
        }
        public void breath(){
            beat();
            System.out.println("呼吸中");
        }
    }

    //定义鸟类
    class Bird{
        private Animal a;
        public Bird(Animal a){
            this.a=a;
        }
        public void breath(){
            a.breath();
        }
        public  void fly(){
            System.out.println("fling in the sky ");
        }
    }

    //定义狼类
    class  Wolf{
        private  Animal a;
        public Wolf(Animal a){
            this.a=a;
        }
        public void breath(){
            a.breath();
        }
        public void run(){
            System.out.println("running in the playground");
        }

    }



