package com.dongdong.spring.test.sort;


import lombok.Data;

import java.util.Stack;

/**
  *
  *  树的遍历
  */
public class PreInPosTraversal {

    @Data
    public static  class Node{
        private  int value;
        private  Node left;
        private  Node right;

        public Node(int value){
            this.value=value;
        }
    }

    //中序遍历
    public static void  inOrderRecur(Node node){
        if(node==null){
            return;
        }
        inOrderRecur(node.left);
        System.out.print(node.value+" ");
        inOrderRecur(node.right);
    }

    //前序遍历
    public static void  preOrderRecur(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.value+" ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    //后序遍历
    public static void  posOrderRecur(Node node){
        if(node==null){
            return;
        }
        posOrderRecur(node.left);
        posOrderRecur(node.right);
        System.out.print(node.value+" ");
    }


    //前序遍历
    public static void  preOrderRecur2(Node node){
        if(node==null){
            return;
        }
        Stack<Node> stack=new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
          node= stack.pop();
          System.out.print(node.value+" ");
          if(node.right!=null) {
              stack.push(node.right);
          }
           if(node.left!=null){
               stack.push(node.left);
           }
        }
        System.out.println();
    }


    //中序遍历
    public  static void inOrderRecur2(Node node){
        if(node==null){
            return;
        }
        //初始化数据
        Stack<Node> stack=new Stack<>();
        while(!stack.isEmpty() || node!=null){
            if(node!=null){
               stack.push(node);
               node=node.left;
            }else{
                node=stack.pop();
                System.out.print(node.value+" ");
                node=node.right;
            }
        }
        System.out.println();
    }


    //后序遍历
    public static void  posOrderRecur2(Node node){
        if(node==null){
            return;
        }
        Stack<Node> stack=new Stack();
        Stack<Node> help=new Stack();
        stack.push(node);
        while (!stack.isEmpty()){
            node=stack.pop();
            help.push(node);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
        while(!help.isEmpty()){
            System.out.print(help.pop().value+" ");
        }

        }


    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);


        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);  // 5 3 2 1 4 8 7 6 10 9 11
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head); //1 2 3 4 5 6 7 8 9 10 11
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head); //1 2 4 3 6 7 9 11 10 8 5
        System.out.println();


        // unrecursive
        System.out.println("============unrecursive=============");
       // preOrderRecur2(head);
       // inOrderRecur2(head);
        posOrderRecur2(head);
    }



}
