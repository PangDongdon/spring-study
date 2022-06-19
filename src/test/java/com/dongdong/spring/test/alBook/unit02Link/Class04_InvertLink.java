package com.dongdong.spring.test.alBook.unit02Link;


/**
 * 反转单向与双向链表
 */
public class Class04_InvertLink {

    /**
     * 反转单向链表
     */
    public static Node invertLinkNode(Node head) {
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


    /**
     * 反转双向链表
     */
    public static Node invertDoubleNode(Node head) {

        return head;
    }

    /**
     * 反转链表的一部分
     */
    public static Node reversePartNode(Node head, int from, int to) {
        Node node1 = head;
        Node pre = null;
        Node post = null;
        int length = 0;
        while (node1 != null) {
            length++;
            pre = length == from - 1 ? node1 : pre;
            post = length == to + 1 ? node1 : post;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > length) {
            return head;
        }
        node1 = pre == null ? head : pre.next;
        Node node2=node1.next;
        node1.next=post;
        Node next=null;
        while (node2 != post) {
            next = node2.next;
            node2.next = node1;
            node1 =node2;
            node2=next;
        }
        if(pre!=null){
            pre.next=node1;
            return head;
        }
        return node1;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        Node node1 = reversePartNode(node,2,3);
        while (node1 != null) {
            System.out.println(node1.getValue());
            node1 = node1.next;
        }
    }
}
