package com.dongdong.spring.test.sort;

import net.dongliu.commons.Sys;

public class Print_All_Subsquences {

       public static void  printAllSubsquence(String str){
           char[] chars=str.toCharArray();
           process(chars,0);
       }

       private static void process(char[] chars ,int i){
           if(chars.length==i){
               System.out.println(String.valueOf(chars));
               return;
           }
           process(chars,i+1);
           char temp=chars[i];
           chars[i]=0;
           process(chars,i+1);
           chars[i]=temp;
       }

    public static void  printAllSubsquence2(String str){
        char[] chars=str.toCharArray();
        process2(chars,0,"");
        System.out.println("");
    }

    private static void process2(char[] chars ,int i,String pre){
        if(chars.length==i){
            if(!pre.equals("")) {
                System.out.println(pre);
            }
            return;
        }
        process2(chars,i+1,pre+String.valueOf(chars[i]));
        process2(chars,i+1,pre);
    }


    public static void main(String[] args) {
        printAllSubsquence2("abc");
    }

}
