package com.dongdong.spring.test.alBook.unit02Link;

import com.dongdong.spring.test.alBook.Utils;

//在单链表中删除指定的值
public class Class13_SingleLinkDelAssignValue {


    private static Node delNode(Node head, int num) {
        while (head != null) {
            if (head.getValue() != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.getValue() == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(6);
        node.next.next.next.next = new Node(6);
        Utils.printNode(delNode(node, 6));
    }
}
