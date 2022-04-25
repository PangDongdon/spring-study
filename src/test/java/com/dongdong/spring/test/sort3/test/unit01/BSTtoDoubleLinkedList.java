package com.dongdong.spring.test.sort3.test.unit01;

import advanced_class_01.Code_04_BSTtoDoubleLinkedList;

public class BSTtoDoubleLinkedList {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

     public  Node bSTtoDoubleLinkedList(Node head){
        if(head==null){
            return  null;
        }
        return process2(head)[0];
     }

    public static  Node[] process2(Node head){
        if(head==null){
            return null;
        }
        Node[] leftNodes = process2(head.left);
        Node[] rightNodes = process2(head.right);
        head.right=null;
        head.left=null;
        if(leftNodes!=null && leftNodes[1]!=null){
            leftNodes[1].right=head;
            head.left=leftNodes[1];
        }
        if(rightNodes!=null && rightNodes[0]!=null){
            rightNodes[0].left=head;
            head.right=rightNodes[0];
        }
        Node leftNode=leftNodes[0]==null? head:leftNodes[0];
        Node rightNode=leftNodes[1]==null? head:rightNodes[1];
        return  new Node[]{leftNode,rightNode};
    }

}
