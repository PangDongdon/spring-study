package com.dongdong.spring.leetcodetop100_3;

/**
 * 两两交换链表中的节点
 */
public class Top30SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null) {
            ListNode first = tmp.next;
            ListNode second = tmp.next.next;
            tmp.next = second;
            first.next = second.next;
            second.next = first;
            tmp = first;
        }
        return dummy.next;
    }
}
