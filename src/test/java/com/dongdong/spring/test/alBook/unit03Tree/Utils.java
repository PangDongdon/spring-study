package com.dongdong.spring.test.alBook.unit03Tree;

public class Utils {

    public  static  void printTree(Node head){
        System.out.println("Print Tree");
        printInOrder(head,0,"H",17);
        System.out.println();
    }

    private  static  void printInOrder(Node node,int level,String flag,int len){
        if(node==null){
            return;
        }
        printInOrder(node.right,level+1,"v",len);
        String value=flag+node.value+flag;
        int left=(len-value.length())/2;
        int right=len-left-value.length();
        value=getSpace(left)+value+getSpace(right);
        System.out.println(getSpace(len*level)+value);
        printInOrder(node.left,level+1,"^",len);
    }


    private static  String getSpace(int num){
        String space=" ";
        StringBuffer buffer=new StringBuffer("");
        for(int i=0;i<num;i++){
            buffer.append(space);
        }
        return buffer.toString();
    }
}
