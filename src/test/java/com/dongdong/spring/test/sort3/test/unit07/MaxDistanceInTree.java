package com.dongdong.spring.test.sort3.test.unit07;



public class MaxDistanceInTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }
    public static class ReturnType{
        public int maxDistance;
        public int h;

        public ReturnType(int m, int h) {
            this.maxDistance = m;;
            this.h = h;
        }
    }

    public static  ReturnType process(Node head){
        if(head==null){
            return  new ReturnType(0,0);
        }
      ReturnType leftNode=process(head.left);
      ReturnType rightNode=process(head.right);
      int includeDistance=leftNode.h+1+rightNode.h;
      int leftDistance=leftNode.maxDistance;
      int rightDistance=rightNode.maxDistance;
      int resultDistance=Math.max(Math.max(leftDistance,rightDistance),includeDistance);
      int maxHit=Math.max(leftNode.h,rightNode.h)+1;
      return  new ReturnType(resultDistance,maxHit);
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);
        head1.right.right = new Node(7);
        head1.left.left.left = new Node(8);
        head1.right.left.right = new Node(9);
        System.out.println(process(head1).maxDistance);

        Node head2 = new Node(1);
        head2.left = new Node(2);
        head2.right = new Node(3);
        head2.right.left = new Node(4);
        head2.right.right = new Node(5);
        head2.right.left.left = new Node(6);
        head2.right.right.right = new Node(7);
        head2.right.left.left.left = new Node(8);
        head2.right.right.right.right = new Node(9);
        System.out.println(process(head2).maxDistance);

    }

}
