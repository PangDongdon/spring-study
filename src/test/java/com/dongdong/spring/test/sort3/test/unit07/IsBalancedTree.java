package com.dongdong.spring.test.sort3.test.unit07;


public class IsBalancedTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnType {
        public int level;
        public boolean isB;

        public ReturnType(int l, boolean is) {
            level = l;
            isB = is;
        }
    }

     public static  boolean isBalance(Node node){
        return process(node,1).isB;
     }

     private  static ReturnType  process(Node node,int level){
        if(node==null){
            return  new ReturnType(level,true);
        }
        ReturnType leftNode=process(node.left,level+1);
        if(!leftNode.isB){
            return  new ReturnType(level,false);
        }
         ReturnType rightNode=process(node.right,level+1);
         if(!rightNode.isB){
             return  new ReturnType(level,false);
         }

         if(rightNode.level-leftNode.level>1){
             return  new ReturnType(level,false);
         }
        return  new ReturnType(Math.max(rightNode.level,leftNode.level),true);
     }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }
}
