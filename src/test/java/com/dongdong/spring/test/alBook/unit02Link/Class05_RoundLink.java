package com.dongdong.spring.test.alBook.unit02Link;

public class Class05_RoundLink {

    private static Node deleteKNodeOfRoundLink(Node head, int m) {

        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node last = head;
        while (last.next == head) {
            last = last.next;
        }
        int count = 0;
        while (last != head) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    //实现时间复杂度为 n
    private Node josephusKill2(Node head, int m) {
        if (head == null || head.next == head || m < 1) {
            return head;
        }
        Node cur = head;
        int n = 0;
        while (cur.next != head) {
            n++;
            cur = cur.next;
        }
        n = getLiveNum(n, m);
        while (--n != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    //计算存活的节点序号
    private int getLiveNum(int n, int m) {
        if (n == 1) {
            return 1;
        }
        return (getLiveNum(n - 1, m) + m - 1) % n + 1;
    }
}
