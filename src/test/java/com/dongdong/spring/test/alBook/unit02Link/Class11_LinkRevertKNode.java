package com.dongdong.spring.test.alBook.unit02Link;

import com.dongdong.spring.test.alBook.Utils;

import java.util.Stack;

//将单链表的每K个节点之间逆序
public class Class11_LinkRevertKNode {

    private static Node reverseKNodes(Node head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node pre = null;
        Node next = null;
        Node cur = head;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == k) {
                pre = resign1(stack, pre, next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    private static Node resign1(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if (left != null) {
            left.next = cur;
        }
        Node next = null;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    private static Node reverseKNode2(Node head, int k) {
        if (k < 2) {
            return head;
        }
        Node cur = head;
        Node pre = null;
        Node next = null;
        Node start = null;
        int count = 1;

        while (cur != null) {
            next = cur.next;
            if (count == k) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    private static void resign2(Node left, Node start, Node end, Node right) {
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right) {
            next = cur.next;
            ;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        //Utils.printNode(reverseKNodes(node, 3));
        Utils.printNode(reverseKNode2(node,3));
    }

}
