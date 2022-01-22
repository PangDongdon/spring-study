package com.dongdong.spring.test.sort;

 /**
  * 汉诺谈问题
  * */
public class Hanoi {

    public static  void haoni(int n){
       if(n>0){
           fun(n,"from","mid","to");
       }
    }

     private static void fun(int n, String from,String mid,String to) {
        if(n==1){
            System.out.println("move"+1+"from:"+from+"to:"+to);
        }else{
            fun(n-1,from,to,mid);
            System.out.println("move"+n+"from:"+from+"to:"+to);
           // fun(1,from,mid,to);
            fun(n-1,mid,from,to);
        }
     }

     public static void main(String[] args) {
         haoni(2);
     }
 }
