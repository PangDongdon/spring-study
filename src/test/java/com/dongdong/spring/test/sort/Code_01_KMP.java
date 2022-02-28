package com.dongdong.spring.test.sort;

import com.dongdong.spring.test.sort.basic_class_02.Code_03_KMP_T1SubtreeEqualsT2;

public class Code_01_KMP {


    private  static  int getIndexOf(String s1,String s2){
        if(s1==null || s2==null || s1.length()<1 || s1.length()<s2.length()){
            return -1;
        }
        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        int c1i=0;
        int c2i=0;
        int[] next=getNextArray(c2);
        while(c1i<c1.length && c2i<c2.length){
            if(c1[c1i]==c2[c2i]){
                c1i++;
                c2i++;
            }else  if(next[c2i]==-1){
                c1i++;
            }else{
                c2i=next[c2i];
            }
        }
        return  c2i==c2.length ? c1i-c2i:-1;
    }



    private  static  int[] getNextArray(char[] chars){
        if(chars==null || chars.length<2){
            return  new int[]{-1};
        }
        int[] next=new  int[chars.length];
        next[0]=-1;
        next[1]=0;
        int pos=2;
        int cn=0;
        while(pos<chars.length){
            if(chars[pos-1]==chars[cn]){
                next[pos++]=++cn;
            }else if(cn>0){
                cn=next[cn];
            }else{
                next[pos++]=0;
            }
        }
        return  next;
    }



    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static String serialByPre(Node head) {
        if(head==null){
            return "#!";
        }
        String res=head.value+"!";
        res+=serialByPre(head.left);
        res+=serialByPre(head.right);
        return  res;
    }

    public static boolean isSubtree(Node t1,Node t2) {
       String s1= serialByPre(t1);
       String s2= serialByPre(t2);
       return  getIndexOf(s1,s2)!=-1;
    }

    public static void main(String[] args) {
        /*String str = "abcabcababaccc";
        String match = "ababa";
        System.out.println(getIndexOf(str, match));*/
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(isSubtree(t1, t2));

    }
}
