package com.dongdong.spring.test.alBook.unit02Link;

import com.dongdong.spring.test.alBook.Utils;

import java.util.HashSet;

//删除无序单链表中值重复出现的节点
public class Class12_DeleteNoOrderLinkrepeatNode {

    private static Node removeRep1(Node head) {
        if (head == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        HashSet<Integer> set = new HashSet<>();
        set.add(head.getValue());
        while (cur != null) {
            if (set.contains(cur.getValue())) {
                pre.next = cur.next;
            } else {
                set.add(cur.getValue());
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    //时间复杂度为
    private static Node removeRep2(Node head) {
        if (head == null) {
            return head;
        }
        Node pre = null;
        Node next = null;
        Node cur = head;

        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.getValue() == next.getValue()) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
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
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(8);
        node.next.next.next.next.next.next.next = new Node(8);
        Utils.printNode(removeRep2(node));
    }
}
