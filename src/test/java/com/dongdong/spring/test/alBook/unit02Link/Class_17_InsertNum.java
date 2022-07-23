package com.dongdong.spring.test.alBook.unit02Link;

import com.dongdong.spring.test.alBook.Utils;

//向有序的环形单链表中插入新节点
public class Class_17_InsertNum {

    private static Node insertNum(Node head, int num) {
        Node node = new Node(num);
        if (head == null) {
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (pre.value <= num && cur.value >= num) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return node.value >= head.value ? head : node;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.next = node2;
        node2.next = node3;
        node3.next = node;
        // Node result = insertNum(node, 0);
        //Utils.printNode(result);
    }
}
