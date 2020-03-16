package com.dongdong.spring.test.testPackage;

/**
 * @Description: 方法的动态分配
 * @Date: 2019/11/18  16:15
 * @Author: dongdong
 */

/**
 * 代码执行过程
 * 1.建立内存空间，调用Man和woman 类型的实例构造器，将这两个实例的引用存放在第1,2 个局部变量表Slot之中
 * 2.创建好的对象的引用压缩到栈顶，将这两个对象将要执行sayHello() 方法的所有者，称为接收者
 * 3.方法调用指令，
 *
 *
 *
 * */
public class DynamicDispatch {

    static abstract class Human{
        protected  abstract void sayHello();
    }

    static class Man extends  Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }
    static class Woman extends  Human{
        @Override
        protected void sayHello() {
            System.out.println("Woman say hello");
        }
    }

    public static void main(String[] args){

        Human man =new Man();
        Human woman=new Woman();
        man.sayHello();
        woman.sayHello();
        man=new Woman();
        man.sayHello();
    }
}
