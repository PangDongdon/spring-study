package com.dongdong.spring.test.alBook.unit02Link;

import com.dongdong.spring.test.alBook.Utils;

//按照左右半区的方式重新组合单链表
public class Class_19_LeftRightWayMakeUpLink {

    private static void relocate(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node mid = head;
        Node right = head.next;
        while (right.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        right = mid.next;
        mid.next = null;
        mergeLR(head, right);
    }

    //左右合并
    private static void mergeLR(Node left, Node right) {
        Node next = null;
        if (left.next != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        left.next = right;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        relocate(node);
        Utils.printNode(node);
    }
}
