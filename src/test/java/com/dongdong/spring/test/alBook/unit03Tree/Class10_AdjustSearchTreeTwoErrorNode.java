package com.dongdong.spring.test.alBook.unit03Tree;

import java.util.Stack;

/**
 * 调整搜索二叉树中两个错误的节点
 */
public class Class10_AdjustSearchTreeTwoErrorNode {

    //find
    private static Node[] getTwoErrorNodes(Node head) {
        Node[] errors = new Node[2];
        if (head == null) {
            return errors;
        }
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.value > head.value) {
                    errors[0] = errors[0] == null ? pre : errors[0];
                    errors[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errors;
    }

    //adjust
    private void adjust() {
        //todo
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        Node[] twoErrorNodes = getTwoErrorNodes(node);
        for (Node node2 : twoErrorNodes) {
            System.out.println(node2.value);
        }
    }

}
