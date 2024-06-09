package com.dongdong.spring.test.alBook.unit02Link;

import com.dongdong.spring.test.alBook.Utils;

import java.util.Stack;

//两个单链表生成相加链表
public class Class09_TwoLinkGerOneLink {

    private static Node addLists(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Node cur = head1;
        //数据都放入栈中
        while (cur != null) {
            stack1.add(cur.getValue());
            cur = cur.next;
        }
        cur = head2;
        while (cur != null) {
            stack2.add(cur.getValue());
            cur = cur.next;
        }
        int ca = 0;
        int n = 0;
        int n1 = 0;
        int n2 = 0;
        Node node = null;
        Node pre = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

    private static Node addLists2(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        head1 = reverseLink(head1);
        head2 = reverseLink(head2);
        int n = 0;
        int n1 = 0;
        int n2 = 0;
        int ca = 0;
        Node node = null;
        Node pre = null;
        while (head1 != null || head2 != null) {
            n1 = head1 != null ? head1.getValue() : 0;
            n2 = head2 != null ? head2.getValue() : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            head1 = head1 != null ? head1.next : null;
            head2 = head2 != null ? head2.next : null;
            ca = n / 10;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        //链表反转回来
        head1 = reverseLink(head1);
        head2 = reverseLink(head2);
        return node;
    }

    //链表的反转
    private static Node reverseLink(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node(9);
        node.next = new Node(3);
        node.next.next = new Node(7);

        Node node1 = new Node(6);
        node1.next = new Node(3);

        Node res = addLists2(node1, node);
        //  Node res1 = addLists(node1, node);

        // Node node3 = reverseLink(node);
        Utils.printNode(res);
        System.out.println();
        //Utils.printNode(res1);
    }

}
