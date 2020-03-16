package com.dongdong.spring.test.testPackage;

import ch.qos.logback.classic.pattern.SyslogStartConverter;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.IntUnaryOperator;

/**
 * @Description:
 * @Date: 2019/12/30  14:00
 * @Author: dongdong
 */
public class testArray {

    @Test
    public void  testArrayLength(){
        int[] a=new int[4];

        int[] b=new int[3];

        a=b;
        System.out.println(a.length);

    }

    @Test
    public void testDoubelArray(){
//        int[][] a;
//        a=new int[4][];
//
//        for(int i=0,len=a.length;i<len;i++){
//            System.out.println(a[i]);
//        }
//        a[0]=new int[2];
//        a[0][1]=6;
//
//        for(int i=0,len1=a[0].length;i<len1;i++){
//            System.out.println(a[0][i]);
//        }

//        String[][] ss={new String[3],new String[]{"Hello Java"}};
//        for(int i=0;i<ss[0].length;i++){
//            System.out.println(ss[0][0]);
//        }
//        System.out.println(ss);
//        int[] a=new  int[] {2,4,6,55,6,5432,3};
//        System.out.println(Arrays.toString(a));

//        int[] arr1=new int[] {3,-4,25,16,30,118};
//        Arrays.parallelSort(arr1);
//        for(int d:arr1)
//        System.out.println(d);

         int [] arry=new int[5];
         Arrays.parallelSetAll(arry, new IntUnaryOperator() {
             @Override
             public int applyAsInt(int operand) {
                 return operand*5;
             }
         });
        System.out.println(Arrays.toString(arry));
    }
}
