package com.dongdong.spring.leetcodetop100_2;

import com.dongdong.spring.test.javaDesignModel16.List;

/**
 *环形链表II
 */
public class Top26DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr=head;
                while (ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
