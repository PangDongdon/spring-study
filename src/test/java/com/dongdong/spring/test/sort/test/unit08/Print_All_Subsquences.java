package com.dongdong.spring.test.sort.test.unit08;

public class Print_All_Subsquences {

    public static  void printAllSub(String s){
        char[] chars=s.toCharArray();
       //f(chars,0,"");
        f2(chars,0);
    }

    public static  void f(char[] chars,int i,String pre){
        if(i==chars.length){
            if(!"".equals(pre)){
                System.out.println(pre);
                return;
            }
        }
        f(chars,i+1,pre+String.valueOf(chars[i]));
        f(chars,i+1,pre);
    }

    public static void f2(char[] chars,int i){
        if(i==chars.length){
            System.out.println(String.valueOf(chars));
            return;
        }
        f2(chars,i+1);
        char temp=chars[i];
        chars[i]=0;
        f2(chars, i+1);
        chars[i]=temp;
    }

    public static void main(String[] args) {
        String test = "abc";
        printAllSub(test);
    }
}
