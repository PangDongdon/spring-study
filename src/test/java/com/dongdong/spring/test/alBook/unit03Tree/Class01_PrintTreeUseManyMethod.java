package com.dongdong.spring.test.alBook.unit03Tree;

import net.dongliu.commons.Sys;

import java.util.Stack;

//分别使用递归非递归方式实现二叉树的先序，中序，后序遍历
public class Class01_PrintTreeUseManyMethod {

    /**
     * 递归遍历
     */
    //先序
    private static void preOderRecur(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOderRecur(node.left);
        preOderRecur(node.right);
    }

    //中序
    private static void inOderRecur(Node node) {
        if (node == null) {
            return;
        }
        preOderRecur(node.left);
        System.out.print(node.value + " ");
        preOderRecur(node.right);
    }

    //后序
    private static void postOrderRecur(Node node) {
        if (node == null) {
            return;
        }
        preOderRecur(node.left);
        preOderRecur(node.right);
        System.out.print(node.value + " ");
    }


    /**
     * 非递归实现
     */
    //前序
    private static void preOderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.value + "");
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }

    //中序
    private static void inOderUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                Node node = stack.pop();
                System.out.print(node.value + "");
                head = node.right;
            }
        }
    }

    //后序
    private static void postUnRecur(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack1 = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            stack1.add(node);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        while (!stack1.isEmpty()) {
            System.out.print(stack1.pop().value + "");
        }
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        //preOderUnRecur(node);
        // inOderUnRecur(node);
        postUnRecur(node);
    }
}
