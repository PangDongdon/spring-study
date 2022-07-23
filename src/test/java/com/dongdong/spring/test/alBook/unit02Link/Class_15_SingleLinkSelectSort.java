package com.dongdong.spring.test.alBook.unit02Link;

//单链表的选择排序
public class Class_15_SingleLinkSelectSort {

    private static Node selectSort(Node head) {
        if (head == null) {
            return head;
        }
        Node tail = null;
        Node cur = head;
        Node smallPre = null;
        Node small = null;
        while (cur != null) {
            small = cur;
            smallPre = getSmallPreNode(head);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }


    private static Node getSmallPreNode(Node head) {
        if (head == null) {
            return head;
        }
        Node small = head;
        Node preSmall = null;
        Node cur = head.next;
        Node pre = head;
        while (cur != null) {
            if (cur.getValue() < small.getValue()) {
                preSmall = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return preSmall;
    }
}
