package com.dongdong.spring.test.alBook.unit02Link;

//合并两个有序的单链表
public class Class_18_MergeOrderLink {

    private static Node mergeTwoOrderLink(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node head = head1.value < head2.value ? head1 : head2;
        Node cur1 = head1 == head ? head1 : head2;
        Node cur2 = head1 == head ? head2 : head1;
        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
