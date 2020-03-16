package com.dongdong.spring.test.testPackage;

import org.junit.Test;

/**
 * @Description:
 * @Date: 2019/12/26  13:57
 * @Author: dongdong
 */
public class allTypeTest {

    @Test
    public void test1(){
        byte a=0B01;
        System.out.println(a);
    }

    @Test
    public void test2(){
//        char achar='a';
//        char enterChar='\r';
//        char ch='\u9999';
//        System.out.println(ch);
//        char zhong='疯';
//        int zhongValue=zhong;
//        System.out.println(zhongValue);
//        char c=97;
//        System.out.println(c);
//        double a=0.0;
//        System.out.println(3/a);
//        System.out.println(3/0);
//        double ss=8_8_4_8.333;
//        System.out.println(ss);
//           int iValue=233;
//           byte b=(byte)233;
//           char b=(char)34;
//          short a=2;
//          a=a-2;
//           System.out.println('a'+2+"dongdong");
//           System.out.println("dongdong"+'a'+2);
//           int b=1;
//           int a=b++ +1;
//           System.out.println(a);
//           System.out.println(b);
             //System.out.println(Math.random());
//             int a=Runtime.getRuntime().availableProcessors();
//             System.out.println(a+"可用线程数");
//             System.out.println(Integer.toBinaryString(5));
//              System.out.println(5^9);
//              System.out.println(~(-5));
//              byte a=5;
//              a+=5;

        for(int i=0;i<10;i++){
            System.out.println(i);
            for(int j=0;j<10;j++){
                if(j==2){
                    System.out.println(j);
                    break;
                }

            }
        }

    }


    public static void main(String[] args){

        for(int i=0;i<10;i++){
            System.out.println("i="+i);
            for(int j=0;j<10;j++){
                if(j==2){
                    System.out.println("j="+j);
                    break ;
                }

            }
        }
    }
}

