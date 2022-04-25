package com.dongdong.spring.test.sort3.test.unit07;



public class BiggestSubBSTInTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class ReturnType{
        public int size;
        public Node head;
        public int min;
        public int max;

        public ReturnType(int a, Node b, int c, int d) {
            this.size =a;
            this.head = b;
            this.min = c;
            this.max = d;
        }
    }

    public static ReturnType process(Node head) {
        if(head==null){
            return  new ReturnType(0,null,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
       ReturnType leftNode=process(head.left);
       ReturnType rightNode=process(head.right);
       int includeSelf=0;
       if(leftNode.head==head.left && rightNode.head==head.right &&
               head.value>leftNode.max && head.value<rightNode.min){
           includeSelf=rightNode.size+1+leftNode.size;
       }
       int leftSize=leftNode.size;
       int rightSize=rightNode.size;
       int   maxValue=Math.max(Math.max(leftSize,rightSize),includeSelf);
       Node maxHead=leftSize>rightSize?leftNode.head:rightNode.head;
       if(maxValue==includeSelf){
           maxHead=head;
       }
        return new ReturnType(maxValue,maxHead
                ,Math.min(Math.min(leftNode.min,rightNode.min),head.value)
                ,Math.max(Math.max(leftNode.max,rightNode.max),head.value));
    }

    public static void main(String[] args) {
       Node head = new Node(6);
        head.left = new Node(1);
        head.left.left = new Node(0);
        head.left.right = new Node(3);
        head.right = new Node(12);
        head.right.left = new Node(10);
        head.right.left.left = new Node(4);
        head.right.left.left.left = new Node(2);
        head.right.left.left.right = new Node(5);
        head.right.left.right = new Node(14);
        head.right.left.right.left = new Node(11);
        head.right.left.right.right = new Node(15);
        head.right.right = new Node(13);
        head.right.right.left = new Node(20);
        head.right.right.right = new Node(16);
        System.out.println(process(head).size);
    }

}
