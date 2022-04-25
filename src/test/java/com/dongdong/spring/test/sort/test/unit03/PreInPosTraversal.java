package com.dongdong.spring.test.sort.test.unit03;

import java.util.Stack;

public class PreInPosTraversal {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    //二叉树前序非递归遍历
    public static void prePrint(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //二叉树中序非递归遍历
    public static void midPrint(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    Node node = stack.pop();
                    System.out.print(node.value + " ");
                    head = node.right;
                }
            }
        }
        System.out.println();
    }

    //二叉树后序非递归遍历
    public static void postNode(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            Stack<Node> help = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                help.push(head);
                if (head.left != null) {
                    stack.push(head.left);
                }
                if (head.right != null) {
                    stack.push(head.right);
                }
            }
            while (!help.isEmpty()) {
                System.out.print(help.pop().value + " ");
            }
        }
        System.out.println();
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
        //pre-order: 5 3 2 1 4 8 7 6 10 9 11
        //in-order: 1 2 3 4 5 6 7 8 9 10 11
        //pos-order: 1 2 4 3 6 7 9 11 10 8 5
        prePrint(head);
        midPrint(head);
        postNode(head);
    }
}
