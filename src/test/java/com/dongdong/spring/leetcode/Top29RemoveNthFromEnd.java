package com.dongdong.spring.leetcode;

/**
 * 删除链表的倒数第n
 */
public class Top29RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode tmp = head;
        int length = 0;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        int needPos = length - n + 1;
        if (needPos == 1) {
            return head.next;
        }
        length = 1;
        tmp = head;
        ListNode pre = head;
        while (tmp != null) {
            if (length == needPos) {
                pre.next = tmp.next;
                break;
            }
            pre = tmp;
            tmp = tmp.next;
            length++;
        }
        return head;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode tmp = head;
        while (tmp != null) {
            pre.next = null;
            tmp.next = pre;
            pre = tmp;
            tmp = tmp.next;
        }
        return pre;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode tail = reverseList(head);
        ListNode tmp = tail;
        ListNode pre = tail;
        int length = 1;
        if (n == 1) {
            return tail.next;
        }
        while (tmp != null) {
            length++;
            if (length == n) {
                pre.next = tmp.next;
                break;
            }
            pre = tmp;
            tmp = tmp.next;
        }
        return reverseList(tail);
    }
}
