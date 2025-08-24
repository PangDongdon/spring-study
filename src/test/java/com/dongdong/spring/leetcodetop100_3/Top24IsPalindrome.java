package com.dongdong.spring.leetcodetop100_3;

/**
 * 回文链表
 */
public class Top24IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        //寻找中点节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode right = reverse(mid);
        ListNode left = head;
        while (right != null && left != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        //恢复链表
        slow.next = reverse(mid);
        return true;
    }

    //反转链表
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
