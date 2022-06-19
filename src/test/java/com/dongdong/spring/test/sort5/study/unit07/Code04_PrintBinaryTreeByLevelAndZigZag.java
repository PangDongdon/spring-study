package com.dongdong.spring.test.sort5.study.unit07;

import java.util.Stack;

public class Code04_PrintBinaryTreeByLevelAndZigZag {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }

        public static void printByZigZag(Node head) {
            if(head==null){
                return;
            }
            Stack<Node> stackA=new Stack<>();
            Stack<Node> stackB=new Stack<>();
            stackA.add(head);
            while(!stackA.isEmpty() || !stackB.isEmpty()) {
                while (!stackA.isEmpty()) {
                    Node node = stackA.pop();
                    System.out.print(node.value + " ");
                    stackB.add(node.left);
                    stackB.add(node.right);
                }

                while (!stackB.isEmpty()) {
                    Node node1 = stackB.pop();
                    if(node1!=null) {
                        System.out.print(node1.value + " ");
                        stackA.add(node1.right);
                        stackA.add(node1.left);
                    }
                }
            }
        }
        public static void main(String[] args) {
            Node head=new Node(1);
            head.left=new Node(2);
            head.right=new Node(3);
            head.left.left=new Node(4);
            head.left.right=new Node(5);
            head.right.left=new Node(6);
            head.right.right=new Node(7);
            printByZigZag(head);
        }
    }

}
