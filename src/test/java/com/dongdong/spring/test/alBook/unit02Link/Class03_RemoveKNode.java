package com.dongdong.spring.test.alBook.unit02Link;

public class Class03_RemoveKNode {

    /**
     * 删除中间节点
     */
    public static Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node next = head.next.next;
        while (next.next != null && next.next.next != null) {
            pre = pre.next;
            next = next.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 删除a*n/b 个节点
     */
    public static Node removeByRatio(Node head, int a, int b) {
        if (head == null || a < 1 || a < b) {
            return head;
        }
        Node cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int value = (int) Math.ceil((double) n * a / (double) b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--value != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
