package com.dongdong.spring.test.sort;


import org.junit.Test;

/**
 * 链表分段排序
 */
public class SmallerEqualBigger {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node partition2(Node head, int data) {
        if (head == null || head.next == null) {
            return null;
        }
        Node cur = head;
        //统计节点数
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] node = new Node[i];
        cur = head;
        for (i = 0; i != node.length; i++) {
            node[i] = cur;
            cur = cur.next;
        }
        arrPartition(node, data);
        for (i = 1; i != node.length; i++) {
            node[i - 1].next = node[i];
        }
        node[i - 1].next = null;
        return node[0];
    }

    private void arrPartition(Node[] node, int data) {
        if (node == null || node.length < 2) {
            return;
        }
        int index = 0;
        int big = node.length;
        int small = -1;
        while (index != big) {
            if (node[index].value < data) {
                swap(node, ++small, index++);
            } else if (node[index].value == data) {
                index++;
            } else {
                swap(node, --big, index);
            }
        }
    }

    private void swap(Node[] node, int a, int b) {
        Node temp = node[a];
        node[a] = node[b];
        node[b] = temp;
    }


    public Node partition(Node head, int data) {
        if (head == null || head.next == null) {
            return null;
        }
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < data) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == data) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    public void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    @Test
    public void test() {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = partition2(head1, 5);
        printLinkedList(head1);
    }


    //Linked List: 7 9 1 8 5 2 5
    //Linked List: 1 2 5 5 7 9 8
}
