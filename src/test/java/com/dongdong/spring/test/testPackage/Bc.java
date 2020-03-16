package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/11/22  9:33
 * @Author: dongdong
 */
public class Bc extends  supC {
    String b;
    public Bc(){

    }
    public  Bc(String b){
        this.b=b;
    }

    public String toString(){
        return "subB";
    }

    public void test(gent<? extends  supC> o){
        System.out.println("BC");
    }

    public  static  void main(String[] args){
        Bc bc=new Bc();
        gent<Bc> bsc=new gent<>();
        bc.test(bsc);
    }
}
class supC{
    public String toString(){
        return "superA";
    }
}
class gent<T> {
    public void test() {
        System.out.println("gent");
    }
}