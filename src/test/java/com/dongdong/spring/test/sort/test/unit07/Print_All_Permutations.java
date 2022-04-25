package com.dongdong.spring.test.sort.test.unit07;

import org.apache.logging.log4j.util.Strings;
import java.util.HashSet;

public class Print_All_Permutations {

    public static  void printStr1(String s){
        if(Strings.isBlank(s)){
            return;
        }
        char[] chars=s.toCharArray();
        process1(chars,0);
    }

    public static void process1(char[] arr,int i){
        if(i==arr.length){
            System.out.println(String.valueOf(arr));
        }
        for(int j=i;j<arr.length;j++){
            swap(arr,i,j);
            process1(arr,i+1);
        }
    }

    public static  void printStr2(String s){
        if(Strings.isBlank(s)){
            return;
        }
        char[] chars=s.toCharArray();
        process2(chars,0);
    }

    public static void process2(char[] arr,int i){
        if(i==arr.length){
            System.out.println(String.valueOf(arr));
        }
        for(int j=i;j<arr.length;j++){
            swap(arr,i,j);
            process1(arr,i+1);
            swap(arr,i,j);
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static  void printStr3(String s){
        if(Strings.isBlank(s)){
            return;
        }
        char[] chars=s.toCharArray();
        process33(chars,0);
    }

    public static void process33(char[] arr,int i){
        if(i==arr.length){
            System.out.println(String.valueOf(arr));
        }
        HashSet<Character> set=new HashSet();
        for(int j=i;j<arr.length;j++){
            if(!set.contains(arr[j])) {
                set.add(arr[j]);
                swap(arr, i, j);
                process33(arr, i + 1);
                swap(arr, i, j);
            }
        }
    }


    public static void main(String[] args) {
        String test1 = "abc";
        printStr1(test1);
        System.out.println("======");
        printStr2(test1);
        System.out.println("======");

        String test2 = "acc";
        printStr3(test2);
        System.out.println("======");

    }
}
