package com.dongdong.spring.leetcodetop100_3;

/**
 * 两数相加
 */
public class Top28AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a1 = l1 != null ? l1.val : 0;
            int a2 = l2 != null ? l2.val : 0;
            int sum = a1 + a2 + carry;
            if (tail == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carry = sum / 10;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
