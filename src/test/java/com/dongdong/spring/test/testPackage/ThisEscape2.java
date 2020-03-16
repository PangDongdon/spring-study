package com.dongdong.spring.test.testPackage;

/** this 逃逸
 * @Description:
 * @Date: 2019/12/20  17:08
 * @Author: dongdong
 */
public class ThisEscape2 {
    final int i;
    int j;
    public ThisEscape2(){
        i=1;
        j=1;
        new Thread(new RunableTest()).start();
    }

    //内部类实现Runnable; 引用外部类
    private class RunableTest implements  Runnable{
        @Override
        public void run() {
            try{
                System.out.println(ThisEscape2.this.i);
            }catch(NullPointerException e){
                System.out.println("空指针异常");
            }

            try{
                System.out.println(ThisEscape2.this.i);
            }catch(NullPointerException e){
                System.out.println("空指针异常");
            }
        }
    }


    public   static void main(String[] args){
        new ThisEscape2();
    }


}
