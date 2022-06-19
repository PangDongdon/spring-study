package com.dongdong.spring.test.sort5.study.unit07;

public class Code03_ReversePartList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reversePart(Node head, int from, int to) {
        Node node = head;
        Node preNode = null;
        Node lastNode = null;
        int len = 0;
        while (node != null) {
            len++;
            preNode = len == from - 1 ? node : preNode;
            lastNode = len == to + 1 ? node : lastNode;
            node = node.next;
        }
        if (from < 1 || from > to || to > len) {
            return head;
        }
        Node node1 = preNode == null ? head : preNode.next;
        Node node2 = node1.next;
        node1.next = lastNode;
        Node next = null;
        while (node2 != lastNode) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (preNode != null) {
            preNode.next = node1;
            return head;
        }
        return node1;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        head = reversePart(head, 1, 3);
        printLinkedList(head);
    }
}
